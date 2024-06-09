package dataproviders;

import dto.BoardDTO;
import interfaces.Path;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderBoard implements Path {

    @DataProvider
    public Iterator<BoardDTO[]> DPFile_deleteBoardPositiveTest(){
        List<BoardDTO[]> list = new ArrayList<>();
        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(CSV_PATH+"boards.csv"));
            String line = bufferedReader.readLine();
            while (line !=null){
                String [] splitArray = line.split(",");
                list.add(new BoardDTO[]{BoardDTO.builder().boardTitle(splitArray[0]).build()});
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list.iterator();
    }
}
