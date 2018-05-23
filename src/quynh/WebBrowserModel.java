package quynh;

import java.util.ArrayList;

public class WebBrowserModel {

    private ArrayList<String> urlList = new ArrayList<>();
    private int currentIndex = -1;
    private String url;

    public WebBrowserModel() {
    }

    public ArrayList<String> getUrlList() {
        return urlList;
    }

    public void setUrlList(ArrayList<String> urlList) {
        this.urlList = urlList;
    }
    
    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    // push the current url into the arrayList
    public void push(String url) {
        
        // if there is the overide url, clear whole next urls
        if (currentIndex < (urlList.size() - 1)) {
            urlList.subList(currentIndex + 1, urlList.size()).clear();
        }
        
        // add the new url into the arraylist
        urlList.add(url);
        
        // point to the next position (index)
        currentIndex++;
    }

    // return the previous url
    public String prev() {
        
        // if there is no previous url, return null url
        if (currentIndex <= 0) {
            currentIndex--;
            url = null;
            
        // if there is a previous url, return the url
        } else {
            currentIndex--;
            url = urlList.get(currentIndex);
        }
        return url;
    }

    public String next() {
        
        // if there is a next url, return the url
        if (currentIndex < (urlList.size() - 1)) {
            currentIndex++;
            url = urlList.get(currentIndex);
            
            // otherwise, return null url
        } else {
            url = null;
        }
        return url;
    }
}
