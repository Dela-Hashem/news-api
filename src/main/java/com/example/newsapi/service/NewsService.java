package com.example.newsapi.service;

import com.example.newsapi.model.News;
import com.example.newsapi.repository.NewsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NewsService {

    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    public Optional<News> getNewsById(Long id) {
        return newsRepository.findById(id);
    }

    public News createNews(News news) {
        return newsRepository.save(news);
    }

    public Optional<News> updateNews(Long id, News updatedNews) {
        return newsRepository.findById(id).map(news -> {
            news.setTitle(updatedNews.getTitle());
            news.setContent(updatedNews.getContent());
            news.setCreatedAt(updatedNews.getCreatedAt());
            return newsRepository.save(news);
        });
    }

    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }
}
