package com.sainsburys.app.engine;

import com.sainsburys.app.model.Result;

public interface Scraper {

    Result scraper(String url);

}