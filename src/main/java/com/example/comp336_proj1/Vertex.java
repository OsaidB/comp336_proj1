package com.example.comp336_proj1;

public class Vertex {
    Source source;
    Vertex previous;
    int num;
//    double distance = Integer.MAX_VALUE;
    boolean visited;
//    LinkedList<edges> e = new LinkedList<edges>();

    public Vertex(Source source, int number) {
        super();
        this.source = source;
        this.num = number;
    }

    public Source getSource() {
        return source;
    }


    public void setSource(Source source) {
        this.source = source;
    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

//    public double getDistance() {
//        return distance;
//    }

//    public void setDistance(int distance) {
//        this.distance = distance;
//    }

//    public LinkedList<edges> getE() {
//        return e;
//    }

//    public void setE(LinkedList<edges> e) {
//        this.e = e;
//    }
//
////    public boolean FindEdge(String ss) {
////
////        for (int i = 0; i < e.size(); i++) {
////            if (e.get(i).getD().getCollege().getResourceNumber().compareToIgnoreCase(ss) == 0)
////                return true;
////        }
////        return false;
////    }

//    public String ttoString() {
//        String r = college.getResourceNumber() + ":";
//        for (int i = 0; i < e.size(); i++) {
//            r = r + e.get(i).desination.college.getResourceNumber() + "\n";
//        }
//        return r;
//    }

    // Usage of comparator
//    public Comparator<Vertex> coNameComparator = new Comparator<Vertex>() {
//
//        @Override
//        public int compare(Vertex o1, Vertex o2) {
//            return 0;
//        }
//
//        // Comparing attributes of
//        public int compare(College c1, College c2) {
//
//            String coName1 = c1.getResourceNumber().toUpperCase();
//            String coName2 = c2.getResourceNumber().toUpperCase();
//
//            // Returning in ascending order
//            return coName1.compareTo(coName2);
//
//            // descending order
//            // return
//            // StudentName2.compareTo(StudentName1);
//        }
//    };

    @Override
    public String toString() {
        return "Vertex{\t"+source+"\t}";
    }
}
