class Link {
    public int data;
    public double dataD;
    public Link next;
    public Link(int id, double d){
        data = id;
        dataD = d;
    }
    public void outputLink(){
        System.out.println("(" + data + " " + dataD + ")");
    }
}

class LinkList {
    private Link first;
    public LinkList() {
        first = null;
    }
    public boolean empty(){
        return (first == null);
    }
    public void insertFirst(int id, double d){
        Link link = new Link(id, d);
        link.next = first;
        first = link;
    }
    public Link deleteFirst(){
        Link tLink = first;
        first = first.next;
        return tLink;
    }
    public void outputList(){
        System.out.println("List (first - last): ");
        Link link = first;
        while (link != null){
            link.outputLink();
            link = link.next;
        }
        System.out.println(" ");
    }
}
class Main {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.insertFirst(11, 1.11d);
        list.insertFirst(22, 2.22d);
        list.insertFirst(33, 3.33d);
        list.insertFirst(44, 4.44d);
        list.outputList();
        while (!list.empty()){
            Link link = list.deleteFirst();
            System.out.println("Deleted");
            link.outputLink();
            System.out.println(" ");
        }
        list.outputList();
    }
}
