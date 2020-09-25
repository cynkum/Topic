package com.belajar.topic.controller;

import com.belajar.topic.TopicRepository;
import com.belajar.topic.config.PropertiesConfig;
import com.belajar.topic.config.ValueConfig;
import com.belajar.topic.model.Topic;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topic")
@Component
@EnableConfigurationProperties(PropertiesConfig.class)
public class TopicController {
//    @Autowired
//    TopicService topicService;

    public TopicController(){

    }
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private PropertiesConfig propertiesConfig;

    private String value;
    private String priority;
    private String listOfValues;

    @PostMapping("/add")
    @ApiOperation(value = "Add a data to topic")
    public @ResponseBody String addNewUser (
            @ApiParam(value = "Please fill the name of the topic", required = true) @RequestParam String name_topic,
            @ApiParam(value = "Please fill the topic's description", required = false) @RequestParam String description_topic,
            @ApiParam(value = "Please fill the year of the topic discovered", required = true) @RequestParam Integer year) {
        Topic topic = new Topic();
        topic.setName(name_topic);
        topic.setDescription(description_topic);
        topic.setYear(year);
        topicRepository.save(topic);
        return "Saved";
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all data of the topic")
    public @ResponseBody Iterable<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    //@ConfigurationProperties
    @GetMapping("/properties")
    public String properties(){
        return propertiesConfig.getHostName() + " -- " + propertiesConfig.getPort() + " -- " +propertiesConfig.getFrom();
    }

    //@Value
    @Autowired
    @GetMapping("/value")
    public String getValue(@Value(ValueConfig.value) String value,
                            @Value(ValueConfig.priotity) String priority, @Value(ValueConfig.listOfValues) String list
    ){
        this.value=value.toLowerCase();
        this.listOfValues=list.toLowerCase();
        this.priority=priority.toLowerCase();
        return value + " -- " +listOfValues + " -- " +priority;
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Topic> saveResource(@RequestBody Topic topic,
//                                              @PathVariable("id") String id) {
//        topicRepository.save(topic, id);
//        return ResponseEntity.ok("resource saved");
//    }

//pemanggilan @NamedQuery
//    static EntityManagerFactory emf= Persistence.createEntityManagerFactory("jpa-db");
//    static EntityManager em = emf.createEntityManager();
//    Query query = em.createNamedQuery("Topic.findAll");
//    List results = query.getResultList();

//LOGGING
    Logger logger = LoggerFactory.getLogger(TopicController.class);
    //@RequestMapping(value="/")
    public String index() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        return "Check out the Logs to see the output...";
    }
}
