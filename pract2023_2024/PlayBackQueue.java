package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.ListIF;
import es.uned.lsi.eped.DataStructures.List;

public class PlayBackQueue implements PlayBackQueueIF{

    ListIF<Integer> content;
    public PlayBackQueue(){
        content = new List<Integer>();
    }
    public ListIF<Integer> getContent(){
        return content;
    }

    public boolean isEmpty(){
        return content.isEmpty();
    }

    public int getFirstTune(){
        return content.get(1);
    }

    public void extractFirstTune(){
        content.remove(1);
    }

    public void addTunes(ListIF<Integer> lT){
        IteratorIF<Integer> it = lT.iterator();
        while(it.hasNext()){
            content.insert(content.size() + 1, it.getNext());
        }
    }

    public void clear(){
        content.clear();
    }
}
