package com.cn.ncist.rq.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.cn.ncist.rq.destination.service.ManagerDestinationService;
import com.cn.ncist.rq.destination.vo.DestinationModel;
import com.cn.ncist.rq.note.service.ManagerNoteService;
import com.cn.ncist.rq.note.vo.NoteModel;
import com.cn.ncist.rq.province.service.ManagerProvinceService;
import com.cn.ncist.rq.province.vo.NationModel;
import com.cn.ncist.rq.province.vo.ProvinceModel;
import com.cn.ncist.rq.user.vo.UserModel;

public class DestinationServlet extends HttpServlet {

	private ManagerDestinationService mds ;
	private ManagerProvinceService mps ;
	
	public ManagerDestinationService getMds() {
		return mds;
	}

	public void setMds(ManagerDestinationService mds) {
		this.mds = mds;
	}
	
	public ManagerProvinceService getMps() {
		return mps;
	}

	public void setMps(ManagerProvinceService mps) {
		this.mps = mps;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
		doPost(req, resp) ;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String reqMessage , respMessage ;
		JSONArray reqObject = null ;
		JSONArray respObject = null ;
		req.setCharacterEncoding("UTF-8") ;
		resp.setContentType("text/json;charset=UTF-8") ;
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					req.getInputStream(), "UTF-8")) ;
			StringBuffer sb = new StringBuffer("") ;
			String temp ;
			while ((temp = br.readLine()) != null) {
				sb.append(temp) ;
			}
			br.close() ;
			reqMessage = sb.toString() ;
			System.out.println("请求报文:" + reqMessage) ;
			reqObject = new JSONArray(reqMessage) ;
			
			JSONObject jo ;
			String action = reqObject.getJSONObject(0).getString("action") ;
			
			if (action.equals("queryAllNation")) {
				List<NationModel> nationlist = mps.queryNation() ;
				
				if (nationlist == null) {//无国家
					respObject = new JSONArray().put(new JSONObject().put("result" , -1)) ;
				} else {
					respObject = new JSONArray() ;
					for(int i = 0; i < nationlist.size(); i++) {
						NationModel nationModel = nationlist.get(i) ;
						respObject.put(new JSONObject()
							.put("result" , 0)
							.put("nationId" , nationModel.getNation_id())
							.put("nationName" , nationModel.getNation_name())) ;
					}
				}
			} else if (action.equals("queryAllProvince")) {
				List<ProvinceModel> provincelist = mps.queryProvinceByNationName(reqObject.getJSONObject(0).getString("nationName")) ;
				
				if (provincelist == null) {//无省份
					respObject = new JSONArray().put(new JSONObject().put("result" , -1)) ;
				} else {
					respObject = new JSONArray() ;
					for(int i = 0; i < provincelist.size(); i++) {
						ProvinceModel provinceModel = provincelist.get(i) ;
						respObject.put(new JSONObject()
							.put("result" , 0)
							.put("provinceId" , provinceModel.getProvince_id())
							.put("provinceName" , provinceModel.getProvince_name())) ;
					}
				}
			} else if (action.equals("queryAllDestination")) {
				List<DestinationModel> listModel = mds.queryAllDestination(reqObject.getJSONObject(0).getString("provinceName")) ;
				
				if (listModel == null) {//无目的地
					respObject = new JSONArray().put(new JSONObject().put("result" , -1)) ;
				} else {
					respObject = new JSONArray() ;
					for(int i = 0; i < listModel.size(); i++) {
						DestinationModel destinationModel = listModel.get(i) ;
						respObject.put(new JSONObject()
							.put("result" , 0)
							.put("destinationId" , destinationModel.getDestination_id())
							.put("destinationName" , destinationModel.getDestination_name())
							.put("destinationPinyin", destinationModel.getDestination_pinyin())
							.put("destinationNumber", destinationModel.getDestination_number())
							.put("destinationImg", destinationModel.getDestination_img())
							.put("destinationImgarr", destinationModel.getDestination_imgarr())
							.put("destinationDesc", destinationModel.getDestination_desc())
							.put("provinceName", destinationModel.getProvince_name())) ;
					}
				}
			}  else if (action.equals("queryDestination")) {
				List<DestinationModel> listModel = mds.queryDestination(reqObject.getJSONObject(0).getString("nationName")) ;
				
				if (listModel == null) {//无目的地
					respObject = new JSONArray().put(new JSONObject().put("result" , -1)) ;
				} else {
					respObject = new JSONArray() ;
					for(int i = 0; i < listModel.size(); i++) {
						DestinationModel destinationModel = listModel.get(i) ;
						respObject.put(new JSONObject()
							.put("result" , 0)
							.put("destinationId" , destinationModel.getDestination_id())
							.put("destinationName" , destinationModel.getDestination_name())
							.put("destinationPinyin", destinationModel.getDestination_pinyin())
							.put("destinationNumber", destinationModel.getDestination_number())
							.put("destinationImg", destinationModel.getDestination_img())
							.put("destinationImgarr", destinationModel.getDestination_imgarr())
							.put("destinationDesc", destinationModel.getDestination_desc())
							.put("provinceName", destinationModel.getProvince_name())) ;
					}
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			respMessage = respObject == null ? "" : respObject.toString();
			System.out.println("返回报文:" + respMessage);
			PrintWriter pw = resp.getWriter();
			pw.write(respMessage);
			pw.flush();
			pw.close();
		}
	}
	
}
