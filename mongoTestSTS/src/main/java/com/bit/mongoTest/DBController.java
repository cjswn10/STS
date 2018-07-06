package com.bit.mongoTest;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

@Controller
public class DBController {

	@RequestMapping("/listDatabase.do")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();

		try {
			Mongo mongo = new Mongo();
			List<String> list = mongo.getDatabaseNames();
			mv.addObject("list", list);
			mongo.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return mv;
	}

	@RequestMapping(value="/listMongoMember.do", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String listMember() {
		String str = "";

		ArrayList<DBObject> list = new ArrayList<DBObject>();
		try {

			Mongo mongo = new Mongo();
			DB db = mongo.getDB("bit");
			DBCollection col = db.getCollection("member");
			DBCursor cursor = col.find();

			while (cursor.hasNext()) {
				list.add(cursor.next());
			}

			ObjectMapper mapper = new ObjectMapper();
			str = mapper.writeValueAsString(list);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return str;
	}
	
	@RequestMapping(value="/search.do", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String searchMember() {
		String str = "";

		ArrayList<DBObject> list = new ArrayList<DBObject>();
		try {

			Mongo mongo = new Mongo();
			DB db = mongo.getDB("bit");
			DBCollection col = db.getCollection("member");
			
			DBObject obj = null;
			
			String id = ((ObjectId)obj.get("_id")).toString();
			
			BasicDBObject ob = new BasicDBObject();
			ob.append("_id", new ObjectId(id));
			DBObject cursor = col.findOne(ob);


			ObjectMapper mapper = new ObjectMapper();
			str = mapper.writeValueAsString(list);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return str;
	}
}
