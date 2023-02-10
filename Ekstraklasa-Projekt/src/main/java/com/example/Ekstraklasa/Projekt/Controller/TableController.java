package com.example.Ekstraklasa.Projekt.Controller;

import com.example.Ekstraklasa.Projekt.Models.EkstraklasaTable;
import com.example.Ekstraklasa.Projekt.Models.Team;
import com.example.Ekstraklasa.Projekt.Repository.TeamRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/table")
public class TableController
{
    private final TeamRepository teamRepository;

    public TableController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping
    public List<EkstraklasaTable> getTable(){

        List<EkstraklasaTable> table = new ArrayList<>();

        for (Team team: teamRepository.findAll())
        {
            EkstraklasaTable tableRecord = new EkstraklasaTable();
            tableRecord.setName(team.getName());
            tableRecord.setMatchCount(team.getWins()+team.getDraws()+team.getLoses());
            tableRecord.setDraws(team.getDraws());
            tableRecord.setLoses(team.getLoses());
            tableRecord.setWins(team.getWins());
            tableRecord.setGoalsScored(team.getGoalsScored());
            tableRecord.setGoalsAgainst(team.getGoalsAgainst());
            tableRecord.setPoints(team.getWins()*3 + team.getDraws());

            table.add(tableRecord);
        }

        table.sort(Comparator.comparing(EkstraklasaTable::getPoints, Comparator.reverseOrder()));

        return table;
    }

    @GetMapping(value = "/export")
    public ResponseEntity<Resource> exportTable(){
        var tableData = getTable();

        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Ekstraklasa");

        Row headerRow = sheet.createRow(0);
        int columnNumber = 0;
        for (Field field : EkstraklasaTable.class.getDeclaredFields())
        {
            Cell cell = headerRow.createCell(columnNumber++);
            cell.setCellValue(field.getName());
        }

        int rowNumber = 1;
        for (EkstraklasaTable team : tableData)
        {
            Row row = sheet.createRow(rowNumber++);
            columnNumber = 0;
            for (Field field : EkstraklasaTable.class.getDeclaredFields()){
                Cell cell = row.createCell(columnNumber++);
                try {
                    cell.setCellValue(field.get(team).toString());
                }
                catch (IllegalAccessException e){
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                }
            }
        }

        File file = new File("TabelaEkstraklasy.xlsx");
        try {
            FileOutputStream stream = new FileOutputStream(file);
            workbook.write(stream);
            workbook.close();
        } catch (Exception e){return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();}

        ByteArrayResource resource = new ByteArrayResource(new byte[0]) ;
        Path path = Paths.get(file.getAbsolutePath());
        try {
            resource = new ByteArrayResource(Files.readAllBytes(path));
        } catch (Exception e){return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();}

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName= TabelaEkstraklasy.xlsx")
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(resource);
    }
}
