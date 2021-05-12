/*
public class TestTSVParsing {

    public static void main(String[] args) {

    }

    private List<TableData> processInputFile(String inputFilePath) {

        List<YourJavaItem> inputList = new ArrayList<YourJavaItem>();

        try{

            File inputF = new File(inputFilePath);
            InputStream inputFS = new FileInputStream(inputF);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));

            // skip the header of the csv
            inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
            br.close();
        } catch (FileNotFoundException|IOException e) {
      ....
        }

        return inputList ;
    }


    private Function<String, YourJavaItem> mapToItem = (line) -> {

        String[] p = line.split("\t");// a CSV has comma separated lines

        YourJavaItem item = new YourJavaItem();

        item.setItemNumber(p[0]);//<-- this is the first column in the csv file
        if (p[3] != null && p[3].trim().length() > 0) {
            item.setSomeProeprty(p[3]);
        }
        //more initialization goes here

        return item;
    }
}
*/
