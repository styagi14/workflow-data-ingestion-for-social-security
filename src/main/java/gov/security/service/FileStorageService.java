package gov.security.service;

import java.io.InputStream;
import java.util.Map;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import com.mongodb.client.gridfs.model.GridFSFile;

@Service
public class FileStorageService {

    private final GridFsTemplate gridFsTemplate;
    private final MongoDatabaseFactory mongoDbFactory;

    public FileStorageService(GridFsTemplate gridFsTemplate, MongoDatabaseFactory mongoDbFactory) {
        this.gridFsTemplate = gridFsTemplate;
        this.mongoDbFactory = mongoDbFactory;
    }

    public String storeFile(InputStream stream, String filename, String contentType, Map<String, Object> metadata) {
        Document meta = new Document();
        if (metadata != null) metadata.forEach(meta::put);
        ObjectId id = gridFsTemplate.store(stream, filename, contentType, meta);
        return id.toHexString();
    }

    public GridFsResource getFileResource(String gridFsId) throws IllegalArgumentException {
        ObjectId id = new ObjectId(gridFsId);
        GridFSFile file = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(id)));
        if (file == null) return null;
        return gridFsTemplate.getResource(file);
    }
}
