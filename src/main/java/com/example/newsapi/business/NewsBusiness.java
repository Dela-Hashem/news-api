package com.example.newsapi.business;


import com.example.newsapi.model.News;
import com.example.newsapi.repository.NewsRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class NewsBusiness {

    private final NewsRepository newsRepository;

    public NewsBusiness(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    public Optional<News> getNewsById(Long id) {
        return newsRepository.findById(id);
    }

    public News saveNews(News news) {
        // اینجا می‌تونی منطق بیزینسی خاص اضافه کنی
        return newsRepository.save(news);
    }

    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }

    public News updateNews(Long id, News newNews) {
        News existing = newsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("News not found"));
        existing.setTitle(newNews.getTitle());
        existing.setContent(newNews.getContent());
        return newsRepository.save(existing);
    }
}
