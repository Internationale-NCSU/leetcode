import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import java.io.*;
import java.util.*;
public class OutputHandler {
    // File f: Each APP's output directory
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public class TaintPath{
        Map<String,Integer> source;
        Map<String,Integer> sink;
        String filename;
        Map<String,String> pair;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public class Aggregation extends TaintPath{
        Map<String,Integer> location;
        Map<String,Integer> microphoneId;
        Map<String,Integer> deviceId;
        Map<String,Integer> file;
        Map<String,Integer> network;

        public Aggregation(TaintPath t){
            this.source = t.source;
            this.sink = t.sink;
            this.filename = t.filename;
            location = new HashMap<>();
            microphoneId = new HashMap<>();
            deviceId = new HashMap<>();
            file = new HashMap<>();
            network = new HashMap<>();
            for (Map.Entry<String, Integer> entry : t.source.entrySet()) {
                String key = entry.getKey();
                if(key.toLowerCase().contains("getLastKnownLocation")){
                    if(location.containsKey(key)){
                        location.put(key,location.get(key)+entry.getValue());
                    }else {
                        location.put(key,entry.getValue());
                    }
                }
                if(key.toLowerCase().contains("setRequestProperty")){
                    if(network.containsKey(key)){
                        network.put(key,network.get(key)+entry.getValue());
                    }else {
                        network.put(key,entry.getValue());
                    }
                }
                if(key.toLowerCase().contains("log")){
                    if(file.containsKey(key)){
                        file.put(key,file.get(key)+entry.getValue());
                    }else {
                        file.put(key,entry.getValue());
                    }
                }
                if(key.toLowerCase().contains("telephony")){
                    if(deviceId.containsKey(key)){
                        deviceId.put(key,deviceId.get(key)+entry.getValue());
                    }else {
                        deviceId.put(key,entry.getValue());
                    }
                }
            }
            for (Map.Entry<String, Integer> entry : t.sink.entrySet()) {
                String key = entry.getKey();
                if(key.contains("getLastKnownLocation")){
                    if(location.containsKey(key)){
                        location.put(key,location.get(key)+entry.getValue());
                    }else {
                        location.put(key,entry.getValue());
                    }
                }
                if(key.contains("setRequestProperty")){
                    if(network.containsKey(key)){
                        network.put(key,network.get(key)+entry.getValue());
                    }else {
                        network.put(key,entry.getValue());
                    }
                }
                if(key.toLowerCase().contains("net")){
                    if(network.containsKey(key)){
                        network.put(key,network.get(key)+entry.getValue());
                    }else {
                        network.put(key,entry.getValue());
                    }
                }
                if(key.toLowerCase().contains("log")){
                    if(file.containsKey(key)){
                        file.put(key,file.get(key)+entry.getValue());
                    }else {
                        file.put(key,entry.getValue());
                    }
                }
                if(key.toLowerCase().contains("telephony")){
                    if(deviceId.containsKey(key)){
                        deviceId.put(key,deviceId.get(key)+entry.getValue());
                    }else {
                        deviceId.put(key,entry.getValue());
                    }
                }
            }
        }
    }
    public void statisticHandler(List<TaintPath> taintPathList,String path){
        try {
            //InputStream inputStream = new FileInputStream("D:\\IdeaProjects\\leetcode1\\574Project4\\src\\output\\TaintPathStatistic.xlsx");
            InputStream inputStream = new FileInputStream(path);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            List<Aggregation> aggregationList = new LinkedList<>();
            taintPathList.forEach(a->{aggregationList.add(new Aggregation(a));});
            taintPathList.forEach(a->{workbook.createSheet(a.getFilename());});
            for (TaintPath taintPath : taintPathList) {
                String sheetName = taintPath.getFilename();
                int len = "com.catscale.weighmytruck-14_su".length();
                Iterator it = workbook.sheetIterator();
                while(it.hasNext()){
                    XSSFSheet sheet = (XSSFSheet) it.next();
                    int rowIndex = sheet.getPhysicalNumberOfRows();
                    if(!sheetName.startsWith(sheet.getSheetName())){
                        continue;
                    }
                    sheet.setColumnWidth(0,20000);
                    XSSFRow row = sheet.createRow(rowIndex);
                    // set up col
                    XSSFCell cell0 = row.createCell(0);
                    cell0.setCellValue("Source Name");
                    XSSFCell cell1 = row.createCell(1);
                    cell1.setCellValue("Count Number");
                    rowIndex++;
                    // add source & sink data to the sheet
                    Map<String,Integer> source = taintPath.getSource();
                    Map<String,Integer> sink = taintPath.getSink();
                    // handle source data
                    for (Map.Entry<String, Integer> entry : source.entrySet()) {
                        System.out.println(entry.getKey());
                        row = sheet.createRow(rowIndex);
                        cell0 = row.createCell(0);
                        cell0.setCellValue(entry.getKey());
                        cell1 = row.createCell(1);
                        cell1.setCellValue(entry.getValue());
                        rowIndex++;
                    }
                    row = sheet.createRow(rowIndex);
                    cell0 = row.createCell(0);
                    cell0.setCellValue("Sink Name");
                    cell1 = row.createCell(1);
                    cell1.setCellValue("Count Number");
                    rowIndex++;
                    for (Map.Entry<String, Integer> entry : sink.entrySet()) {
                        System.out.println(entry.getKey());
                        row = sheet.createRow(rowIndex);
                        cell0 = row.createCell(0);
                        cell0.setCellValue(entry.getKey());
                        cell1 = row.createCell(1);
                        cell1.setCellValue(entry.getValue());
                        rowIndex++;
                    }
                }
            }

            for (Aggregation aggregation : aggregationList) {
                String sheetName = aggregation.getFilename();
                int len = "com.catscale.weighmytruck-14_su".length();
                Iterator it = workbook.sheetIterator();
                while(it.hasNext()) {
                    XSSFSheet sheet = (XSSFSheet) it.next();
                    if (!sheetName.startsWith(sheet.getSheetName())) {
                        continue;
                    }
                    Map<String, Integer> location = aggregation.getLocation();
                    Map<String, Integer> deviceId = aggregation.getDeviceId();
                    Map<String, Integer> file = aggregation.getFile();
                    Map<String, Integer> network = aggregation.getNetwork();
                    int rowIndex = sheet.getPhysicalNumberOfRows();
                    // set up initial col width
                    sheet.setColumnWidth(0, 20000);
                    XSSFRow row = sheet.createRow(rowIndex);
                    // set up col
                    XSSFCell cell0 = row.createCell(0);
                    cell0.setCellValue("location source");
                    XSSFCell cell1 = row.createCell(1);
                    cell1.setCellValue("Count Number");
                    rowIndex++;
                    System.out.println("rowIndex: "+rowIndex);
                    // add source & sink data to the sheet
                    // handle source data
                    for (Map.Entry<String, Integer> entry : location.entrySet()) {
                        // System.out.println(entry.getKey());
                        row = sheet.createRow(rowIndex);
                        cell0 = row.createCell(0);
                        cell0.setCellValue(entry.getKey());
                        cell1 = row.createCell(1);
                        cell1.setCellValue(entry.getValue());
                        rowIndex++;
                    }
                    row = sheet.createRow(rowIndex);
                    cell0 = row.createCell(0);
                    cell0.setCellValue("device source");
                    cell1 = row.createCell(1);
                    cell1.setCellValue("Count Number");
                    rowIndex++;
                    System.out.println("rowIndex: "+rowIndex);
                    for (Map.Entry<String, Integer> entry : deviceId.entrySet()) {
                        // System.out.println(entry.getKey());
                        row = sheet.createRow(rowIndex);
                        cell0 = row.createCell(0);
                        cell0.setCellValue(entry.getKey());
                        cell1 = row.createCell(1);
                        cell1.setCellValue(entry.getValue());
                        rowIndex++;
                    }
                    row = sheet.createRow(rowIndex);
                    cell0 = row.createCell(0);
                    cell0.setCellValue("file source");
                    cell1 = row.createCell(1);
                    cell1.setCellValue("Count Number");
                    rowIndex++;
                    for (Map.Entry<String, Integer> entry : file.entrySet()) {
                        // System.out.println(entry.getKey());
                        row = sheet.createRow(rowIndex);
                        cell0 = row.createCell(0);
                        cell0.setCellValue(entry.getKey());
                        cell1 = row.createCell(1);
                        cell1.setCellValue(entry.getValue());
                        rowIndex++;
                    }
                    row = sheet.createRow(rowIndex);
                    cell0 = row.createCell(0);
                    cell0.setCellValue("network source");
                    cell1 = row.createCell(1);
                    cell1.setCellValue("Count Number");
                    rowIndex++;
                    for (Map.Entry<String, Integer> entry : network.entrySet()) {
                        // System.out.println(entry.getKey());
                        row = sheet.createRow(rowIndex);
                        cell0 = row.createCell(0);
                        cell0.setCellValue(entry.getKey());
                        cell1 = row.createCell(1);
                        cell1.setCellValue(entry.getValue());
                        rowIndex++;
                    }
                }
            }
            workbook.write(new FileOutputStream(path));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void dataPathHandler(List<TaintPath> taintPathList,String file){
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            taintPathList.forEach(a->{workbook.createSheet(a.getFilename());});
            for (TaintPath taintPath : taintPathList) {
                String sheetName = taintPath.getFilename();
                Iterator it = workbook.sheetIterator();
                while(it.hasNext()) {
                    XSSFSheet sheet = (XSSFSheet) it.next();
                    if (!sheetName.startsWith(sheet.getSheetName())) {
                        continue;
                    }
                    Map<String,String> pair = taintPath.getPair();
                    int rowIndex = sheet.getPhysicalNumberOfRows();
                    // set up initial col width
                    sheet.setColumnWidth(0, 20000);
                    sheet.setColumnWidth(1,20000);
                    XSSFRow row = sheet.createRow(rowIndex);
                    // set up col
                    XSSFCell cell0 = row.createCell(0);
                    cell0.setCellValue("taint source");
                    XSSFCell cell1 = row.createCell(1);
                    cell1.setCellValue("taint sink");
                    rowIndex++;
                    System.out.println("rowIndex: "+rowIndex);
                    // add source & sink data to the sheet
                    // handle source data
                    for (Map.Entry<String, String> entry : pair.entrySet()) {
                        // System.out.println(entry.getKey());
                        row = sheet.createRow(rowIndex);
                        cell0 = row.createCell(0);
                        cell0.setCellValue(entry.getKey());
                        cell1 = row.createCell(1);
                        cell1.setCellValue(entry.getValue());
                        rowIndex++;
                    }
                }
            }
            workbook.write(new FileOutputStream(file));
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
    public TaintPath fileHandler(File f,String suffix){
        if(f.getName().endsWith("error")||f.getName().endsWith("xlsx")||!f.getName().endsWith(suffix)){
            return null;
        }
        File result = new File(f.getAbsolutePath()+"\\result\\AppData.txt");
        Map<String,Integer> source  = new HashMap<>();
        Map<String,Integer> sink = new HashMap<>();
        Map<String,String> pair = new HashMap<>();
        try{
            Scanner sc = new Scanner(new FileReader(result));
            String tmpSource = "-1";
            while(sc.hasNextLine()){
                String line = sc.nextLine().trim();
                // System.out.println(line);
                if(line.startsWith("Source:")){
                    String content = line.substring(7);
                    if (source.containsKey(content)){
                        source.put(content,source.get(content)+1);
                    }else {
                        source.put(content,1);
                    }
                    if(tmpSource.equals("-1")) {
                        tmpSource = content;
                    }
                }else if(line.startsWith("Sink:")){
                    String content = line.substring(5);
                    if (sink.containsKey(content)){
                        sink.put(content,sink.get(content)+1);
                    }else {
                        sink.put(content,1);
                    }
                    if(!tmpSource.equals("-1")){
                        pair.put(tmpSource,content);
                    }
                    tmpSource = "-1";
                }

            }
        }catch (IOException e){
            e.printStackTrace();
        }
        TaintPath t = new TaintPath(source,sink,f.getName(),pair);
        return t;
    }
    @Test
    public void test(){
        File f = new File("D:\\IdeaProjects\\leetcode1\\574Project4\\src\\output");
        File[] files = f.listFiles();
        List<TaintPath> list = new LinkedList<>();
        for (File file : files) {
            TaintPath t = fileHandler(file,"alt");
            if(t!=null) {
                list.add(t);
            }
        }
        statisticHandler(list,"D:\\IdeaProjects\\leetcode1\\574Project4\\src\\output\\AltAnalysis.xlsx");
        //dataPathHandler(list,"D:\\IdeaProjects\\leetcode1\\574Project4\\src\\output\\DataPathAlt.xlsx");
    }
}
