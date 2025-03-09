package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.ListIF;
import es.uned.lsi.eped.DataStructures.List;



public class RecentlyPlayed implements RecentlyPlayedIF {

    ListIF<Integer> recentlyPlayedSongs;
    int maxSize;

    public RecentlyPlayed(int maxSize) {
        this.recentlyPlayedSongs = new List<Integer>();
        this.maxSize = maxSize;
    }

    public ListIF<Integer> getContent() {
        ListIF<Integer> reversedList = new List<Integer>();
        IteratorIF<Integer> it = recentlyPlayedSongs.iterator();
        while (it.hasNext()){
            reversedList.insert(1, it.getNext());
        }
        return reversedList;
    }

    public void addTune(int tuneID){
        if (recentlyPlayedSongs.size() > maxSize){
            recentlyPlayedSongs.remove(1);
        }
        else{
            recentlyPlayedSongs.insert(recentlyPlayedSongs.size() + 1, tuneID);
        }
    }
}
