import java.util.List;

public class Runner {
    public static void main(String[] args) {
        double intCollection = IntegersCollection.integerCollection(List.of(1,2,3,4,5,6,7,8,9,10));
        System.out.println(intCollection);

        List<ConvertStringCollection.Bi> bi1 = ConvertStringCollection.convertCollection(new String[]{"one","two","tree",
                "four","five"});
        System.out.println(bi1);

        List<String> stringList = FilterStringCollection.filterCollection(List.of("onE", "tWo", "TREE", "four", "FiVe", "SiX", "seVeN", "EigHt", "nINe"));
        System.out.println(stringList);
    }
}
