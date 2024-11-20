package com.solvd.laba.carina.demo;

import com.solvd.laba.carina.demo.api.post.DeletePostMethod;
import com.solvd.laba.carina.demo.api.post.GetPostMethod;
import com.solvd.laba.carina.demo.api.post.PostPostMethod;
import com.solvd.laba.carina.demo.api.post.PutPostMethod;
import com.zebrunner.carina.api.APIMethodPoller;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class PostAPITest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "ivan")
    public void testGetPost() {
        GetPostMethod getUserMethods = new GetPostMethod();
        getUserMethods.callAPIExpectSuccess();
        getUserMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getUserMethods.validateResponseAgainstSchema("api/posts/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "ivan")
    public void testDeletePost() {
        DeletePostMethod deletePostMethod = new DeletePostMethod();
        deletePostMethod.callAPIExpectSuccess();
        deletePostMethod.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "ivan")
    public void createPostTest(){
        LOGGER.info("test");
        setCases("1");
        PostPostMethod api = new PostPostMethod();
        api.setProperties("api/posts/createPost.properties");

        AtomicInteger counter = new AtomicInteger(0);

        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "ivan")
    public void updatePostTest(){
        LOGGER.info("test");
        setCases("2");
        PutPostMethod api = new PutPostMethod();
        api.setProperties("api/posts/updatePost.properties");

        AtomicInteger counter = new AtomicInteger(0);

        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        api.validateResponse();
    }

/*
    @Test()
    @MethodOwner(owner = "ivan")
    public void getPostCommentsTest(){

    }

    @Test()
    @MethodOwner(owner = "ivan")
    public void getCommentsByPostIdTest(){

    }*/
}
