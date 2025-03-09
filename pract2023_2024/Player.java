package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;


public class Player implements PlayerIF {
    TuneCollection tuneCollection;
    PlayListManager playListManager;
    PlayBackQueue playBackQueue;
    RecentlyPlayed recentlyPlayed;

    public Player(TuneCollection tuneCollection, int size) {
        this.tuneCollection = tuneCollection;
        this.playListManager = new PlayListManager();
        this.playBackQueue = new PlayBackQueue();
        this.recentlyPlayed = new RecentlyPlayed(size);
    }

    public ListIF<String> getPlayListIDs(){
        return playListManager.getIDs();
    }

    public ListIF<Integer> getPlayListContent(String playListID){
        if(!playListManager.contains(playListID)){
            System.out.println("La playlist no existe");
        }

        IteratorIF<Integer> it = playListManager.getPlayList(playListID).getPlayList().iterator();
        ListIF<Integer> list = new List<>();
        while(it.hasNext()){
            list.insert(list.size() + 1, it.getNext());
        }
        return list;
    }

    public ListIF<Integer> getPlayBackQueue(){
        return playBackQueue.getContent();
    }

    public ListIF<Integer> getRecentlyPlayed(){
        return recentlyPlayed.getContent();
    }

    public void createPlayList(String playListID){
        if(!playListManager.contains(playListID)){
            playListManager.createPlayList(playListID);
        }
    }

    public void removePlayList(String playListID){
        if(playListManager.contains(playListID)){
            playListManager.removePlayList(playListID);
        }
    }

    public void addListOfTunesToPlayList(String playListID, ListIF<Integer> lT){
        if(!playListManager.contains(playListID)){
            System.out.println("La playlist no existe");
        }
        else{
            playListManager.getPlayList(playListID).addListOfTunes(lT);
        }

    }

    public void addSearchToPlayList(String playListID,
                                    String t, String a, String g, String al,
                                    int min_y, int max_y,
                                    int min_d, int max_d){
        if (!playListManager.contains(playListID)) {
            System.out.println("La playlist no existe");
        }
       ListIF<Integer> matchingTunes = new List<Integer>();
       Tune tune;

       for (int i = 0; i < tuneCollection.size(); i++){
            tune = tuneCollection.getTune(i);
            if((t.isEmpty() || tune.getTitle().equals(t)) &&
            (a.isEmpty() || tune.getTitle().equals(a)) &&
            (g.isEmpty() || tune.getTitle().equals(g)) &&
            (al.isEmpty() || tune.getTitle().equals(al)) &&
                    (min_y == -1 || tune.getYear() >= min_y) &&
                    (max_y == -1 || tune.getYear() <= max_y) &&
                    (min_d == -1 || tune.getDuration() >= min_d) &&
                    (max_d == -1 || tune.getDuration() >= max_d)){

                matchingTunes.insert(matchingTunes.size() + 1, tune.getID());
            }
        }
        playListManager.getPlayList(playListID).addListOfTunes(matchingTunes);
    }

    public void removeTuneFromPlayList(String playListID, int tuneID){
        if (!playListManager.contains(playListID)) {
            System.out.println("La playlist no existe");
        }
        playListManager.getPlayList(playListID).removeTune(tuneID);
    }

    public void addListOfTunesToPlayBackQueue(ListIF<Integer> lT){
        if (lT != null){
            playBackQueue.addTunes(lT);
        }
    }

    public void addSearchToPlayBackQueue(String t, String a, String g, String al,
                                         int min_y, int max_y,
                                         int min_d, int max_d){

        ListIF<Integer> matchingTunes = new List<Integer>();
        Tune tune;

        for (int i = 0; i < tuneCollection.size(); i++){
            tune = tuneCollection.getTune(i);
            if((t.isEmpty() || tune.getTitle().equals(t)) &&
                    (a.isEmpty() || tune.getTitle().equals(a)) &&
                    (g.isEmpty() || tune.getTitle().equals(g)) &&
                    (al.isEmpty() || tune.getTitle().equals(al)) &&
                    (min_y == -1 || tune.getYear() >= min_y) &&
                    (max_y == -1 || tune.getYear() <= max_y) &&
                    (min_d == -1 || tune.getDuration() >= min_d) &&
                    (max_d == -1 || tune.getDuration() >= max_d)){
                matchingTunes.insert(matchingTunes.size() + 1, tune.getID());
            }
        }
        playBackQueue.addTunes(matchingTunes);
    }

    public void addPlayListToPlayBackQueue(String playListID){
        if (!playListManager.contains(playListID)) {
            System.out.println("La playlist no existe");
        }

        playBackQueue.addTunes(playListManager.getPlayList(playListID).getPlayList());
    }

    public void clearPlayBackQueue(){
        playBackQueue.clear();
    }

    public void play(){
        if (!playBackQueue.isEmpty()){
            int lastTuneID = playBackQueue.getFirstTune();
            playBackQueue.extractFirstTune();
            recentlyPlayed.addTune(lastTuneID);
        }
    }
}
