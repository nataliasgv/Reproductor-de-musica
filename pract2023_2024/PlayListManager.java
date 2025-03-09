package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.ListIF;
import es.uned.lsi.eped.DataStructures.List;

public class PlayListManager implements PlayListManagerIF {
    ListIF<PlayList> playLists;

    public PlayListManager() {
        playLists = new List<>();
    }

    public boolean contains(String playListID){
        IteratorIF<PlayList> it = playLists.iterator();
        while(it.hasNext()){
            if(it.getNext().getID().equals(playListID)){
                return true;
            }
        }
            return false;
    }

    public PlayListIF getPlayList(String playListID){
        IteratorIF<PlayList> it = playLists.iterator();
        PlayList i;
        while(it.hasNext()){
            i = it.getNext();
            if (i.getID().equals(playListID)){
                return i;
            }
        }
        return null;
    }

    public ListIF<String> getIDs(){
        ListIF<String> listIds = new List<>();
        IteratorIF<PlayList> it = playLists.iterator();
        while(it.hasNext()){
            listIds.insert(listIds.size() + 1, it.getNext().getID());
        }
        return listIds;
    }

    public void createPlayList(String playListID){
        if(!contains(playListID)){
            playLists.insert(playLists.size() +1, new PlayList(playListID));
        }
    }

    public void removePlayList(String playListID){
        IteratorIF<PlayList> it = playLists.iterator();
        int pos = 1;
        while(it.hasNext()) {
            if (it.getNext().getID().equals(playListID)) {
                playLists.remove(pos);
                pos--;
            }
            pos++;
        }
    }
}
