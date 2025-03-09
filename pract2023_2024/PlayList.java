package es.uned.lsi.eped.pract2023_2024;
import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.ListIF;
import es.uned.lsi.eped.DataStructures.List;

public class PlayList implements PlayListIF {
    ListIF<Integer> playList;
    String ID;


    public PlayList(String playListID){
        this.ID = playListID;
        this.playList = new List<>();
    }

    public String getID(){
        return ID;
    }

    public ListIF<Integer> getPlayList() {
        IteratorIF<Integer> it = playList.iterator();
        ListIF<Integer> list = new List<>();
        int pos = 1;

        while (it.hasNext()) {
            list.insert(pos, it.getNext());
            pos++;
        }
        return list;
    }

    public void addListOfTunes(ListIF<Integer> lT){
        IteratorIF<Integer> it = lT.iterator();
        while(it.hasNext()){
            playList.insert(playList.size() + 1, it.getNext());
        }
    }

    public void removeTune(int tuneID){
        IteratorIF<Integer> it = playList.iterator();
        int pos = 1;
        while(it.hasNext()) {
            if (it.getNext().equals(tuneID)) {
                playList.remove(pos);
                pos--;
            }
            pos++;
        }
    }
}