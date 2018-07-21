public class LinkList {
    private class  Node{
        String Id = null;
        int _count;
        private Node next = null;
        public Node(){
            _count = 0;
            Id = null;
        }
        public Node(String Id,int _count){
            this._count = _count;
            this.Id = Id;
        }
    }

    private Node head;
    private Node rear;
    private Node temp;
    private Node point;
    private int Length;

    public void initLink(){
        head = new Node();
        rear = head;
        Length = 0;
    }

    public void addlink(String id,int count){
        point = new Node(id,count);
        rear.next = point;
        rear = point;
        Length++;
    }
    public void sortLink(){
        point = head.next;

        String temp_id;
        int temp_count;
        while (point != rear){
            temp = point.next;
            while (temp != rear){
                if(point._count > temp._count){
                    temp_count = point._count;
                    point._count = temp._count;
                    temp._count = temp_count;
                    temp_id = point.Id;
                    point.Id = temp.Id;
                    temp.Id = temp_id;
                }
                temp = temp.next;
            }
            point = point.next;
        }
    }
    public void disPlay(){
        point =head.next;
        int i = 1;
        System.out.println("排名  ID   次数");
        while (true){
            System.out.println(" "+i+"    "+point.Id+"     "+point._count);
            i++;
            if (point == rear) break;
            point = point.next;
        }
    }
    public int getLength(){
        return Length;
    }
}
