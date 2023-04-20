package com.example.springbootdb4.cacheAOP;

import com.example.springbootdb4.entity.Teacher;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;

@Aspect
public class TeacherServiceCache {

    @Autowired
    private ConcurrentMapCacheManager concurrentMapCacheManager;

    @Pointcut("execution(public *  com.example.springbootdb4.service.TeacherService.saveTeacher(..))")
    public void saveTeacher() {

    }

    @Before("saveTeacher()")
    public void addToCache(JoinPoint joinPoint) {
        Teacher teacher;

        for(Object object : joinPoint.getArgs()) {
            if(object instanceof Teacher) {
                teacher = (Teacher) object;
                String teacherId = teacher.getTeacherId();
                Cache cache = concurrentMapCacheManager.getCache("teacher");
                if (cache != null) {
                    cache.put(teacherId, teacher);
                }
            }
        }
    }

}
