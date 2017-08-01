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
import com.cn.ncist.rq.note.service.ManagerNoteService;
import com.cn.ncist.rq.note.vo.CommentModel;
import com.cn.ncist.rq.note.vo.NoteModel;
import com.cn.ncist.rq.user.vo.UserModel;

public class NoteServlet extends HttpServlet {

	private ManagerNoteService mns ;
	private ManagerDestinationService mds ;
	
	public ManagerNoteService getMns() {
		return mns;
	}

	public void setMns(ManagerNoteService mns) {
		this.mns = mns;
	}
	
	public ManagerDestinationService getMds() {
		return mds;
	}

	public void setMds(ManagerDestinationService mds) {
		this.mds = mds;
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
			
			if (action.equals("queryTtNote")) {
				NoteModel noteModel = mns.queryTtNote() ;
				
				if (noteModel == null) {//无游记
					noteModel = new NoteModel() ;
					noteModel.setNote_id(Integer.valueOf(-1)) ;
					//respObject = new JSONArray().put(new JSONObject().put("noteModel" , -1)) ;
				} //else {
				//respObject = new JSONArray().put(new JSONObject(noteModel).toString()) ;
				
					respObject = new JSONArray().put(new JSONObject()
								.put("noteId" , noteModel.getNote_id())
								.put("noteTitle" , noteModel.getNote_title())
								.put("noteDate", noteModel.getNote_date())
								.put("noteDays", noteModel.getNote_days())
								.put("noteExpend", noteModel.getNote_expend())
								.put("notePartner", noteModel.getNote_partner())
								.put("noteContent", noteModel.getNote_content())
								.put("noteAddress", noteModel.getNote_address())
								.put("noteBg", noteModel.getNote_bgimg())
								.put("noteImg", noteModel.getNote_img())
								.put("noteUser", noteModel.getUser_name())
								.put("userTx", noteModel.getUser_touxiang())
								.put("noteLlnum", noteModel.getNote_seenumber())
								.put("noteZnum", noteModel.getNote_zannumber())
								.put("notePlnum", noteModel.getNote_commentnumber())) ;
				//}
			} else if (action.equals("queryAllNote")) {
				List<NoteModel> listModel = mns.queryAllNote(reqObject.getJSONObject(0).getString("noteAddress")) ;
				
				if (listModel == null) {//无游记
					respObject = new JSONArray().put(new JSONObject().put("result" , -1)) ;
				} else {
					respObject = new JSONArray() ;
					for(int i = 0; i < listModel.size(); i++) {
						NoteModel noteModel = listModel.get(i) ;
						respObject.put(new JSONObject()
							.put("result" , 0)
							.put("noteId" , noteModel.getNote_id())
							.put("noteTitle" , noteModel.getNote_title())
							.put("noteDate", noteModel.getNote_date())
							.put("noteDays", noteModel.getNote_days())
							.put("noteExpend", noteModel.getNote_expend())
							.put("notePartner", noteModel.getNote_partner())
							.put("noteContent", noteModel.getNote_content())
							.put("noteAddress", noteModel.getNote_address())
							.put("noteBg", noteModel.getNote_bgimg())
							.put("noteImg", noteModel.getNote_img())
							.put("noteUser", noteModel.getUser_name())
							.put("userTx", noteModel.getUser_touxiang())
							.put("noteLlnum", noteModel.getNote_seenumber())
							.put("noteZnum", noteModel.getNote_zannumber())
							.put("notePlnum", noteModel.getNote_commentnumber())) ;
					}
				}
			} else if (action.equals("queryMyNote")) {
				List<NoteModel> listModel = mns.queryMyNote(reqObject.getJSONObject(0).getInt("userId")) ;
				
				if (listModel == null) {//无游记
					respObject = new JSONArray().put(new JSONObject().put("result" , -1)) ;
				} else {
					respObject = new JSONArray() ;
					for(int i = 0; i < listModel.size(); i++) {
						NoteModel noteModel = listModel.get(i) ;
						respObject.put(new JSONObject()
							.put("result" , 0)
							.put("noteId" , noteModel.getNote_id())
							.put("noteTitle" , noteModel.getNote_title())
							.put("noteDate", noteModel.getNote_date())
							.put("noteDays", noteModel.getNote_days())
							.put("noteExpend", noteModel.getNote_expend())
							.put("notePartner", noteModel.getNote_partner())
							.put("noteContent", noteModel.getNote_content())
							.put("noteAddress", noteModel.getNote_address())
							.put("noteBg", noteModel.getNote_bgimg())
							.put("noteImg", noteModel.getNote_img())
							.put("noteLlnum", noteModel.getNote_seenumber())
							.put("noteZnum", noteModel.getNote_zannumber())
							.put("notePlnum", noteModel.getNote_commentnumber())) ;
					}
				}
			} else if (action.equals("queryNote")) {
				NoteModel noteModel = mns.queryNoteById(reqObject.getJSONObject(0).getInt("noteId")) ;
				
				if (noteModel == null) {//无游记
					respObject = new JSONArray().put(new JSONObject().put("result" , -1)) ;
				} else {
					respObject = new JSONArray() ;
						respObject.put(new JSONObject()
							.put("result" , 0)
							.put("noteId" , noteModel.getNote_id())
							.put("noteTitle" , noteModel.getNote_title())
							.put("noteDate", noteModel.getNote_date())
							.put("noteDays", noteModel.getNote_days())
							.put("noteExpend", noteModel.getNote_expend())
							.put("notePartner", noteModel.getNote_partner())
							.put("noteContent", noteModel.getNote_content())
							.put("noteAddress", noteModel.getNote_address())
							.put("noteBg", noteModel.getNote_bgimg())
							.put("noteImg", noteModel.getNote_img())
							.put("noteUser", noteModel.getUser_name())
							.put("userTx", noteModel.getUser_touxiang())
							.put("noteLlnum", noteModel.getNote_seenumber())
							.put("noteZnum", noteModel.getNote_zannumber())
							.put("notePlnum", noteModel.getNote_commentnumber())) ;
				}
			} else if (action.equals("saveNote")) {
				NoteModel noteModel = new NoteModel() ;
				noteModel.setNote_title(reqObject.getJSONObject(0).getString("noteTitle")) ;
				noteModel.setNote_date(reqObject.getJSONObject(0).getString("noteDate")) ;
				noteModel.setUser_id(reqObject.getJSONObject(0).getInt("userId")) ;
				noteModel.setNote_commentnumber(Integer.valueOf(0)) ;
				noteModel.setNote_zannumber(Integer.valueOf(0)) ;
				noteModel.setNote_seenumber(Integer.valueOf(0)) ;
				noteModel.setNote_days(reqObject.getJSONObject(0).getInt("noteDays")) ;
				noteModel.setNote_expend(reqObject.getJSONObject(0).getString("noteExpend")) ;
				noteModel.setNote_partner(reqObject.getJSONObject(0).getString("notePartner")) ;
				noteModel.setNote_address(reqObject.getJSONObject(0).getString("noteAddress")) ;
				noteModel.setNote_bgimg(reqObject.getJSONObject(0).getString("noteBg")) ;
				noteModel.setNote_img(reqObject.getJSONObject(0).getString("noteImg")) ;
				noteModel.setNote_content(reqObject.getJSONObject(0).getString("noteContent")) ;
				
				mds.updateDesNum(noteModel.getNote_address()) ;
				String flag = mns.saveNote(noteModel) ;
				
				if (!flag.equals("ok")) {//保存失败
					respObject = new JSONArray().put(new JSONObject().put("result" , -1)) ;
				} else {
					respObject = new JSONArray().put(new JSONObject().put("result" , 0)) ;
				}
			}  else if (action.equals("updateNationZan")) {
				Integer zannum = mns.updateNoteZan(Integer.valueOf(reqObject.getJSONObject(0).getInt("noteId"))) ;
				
				respObject = new JSONArray().put(new JSONObject().put("noteZan" , zannum.intValue())) ;
			} else if (action.equals("queryAllComment")) {
				List<CommentModel> listModel = mns.queryAllComment(reqObject.getJSONObject(0).getInt("noteId")) ;
				
				if (listModel == null) {//无评论
					respObject = new JSONArray().put(new JSONObject().put("result" , -1)) ;
				} else {
					respObject = new JSONArray() ;
					for(int i = 0; i < listModel.size(); i++) {
						CommentModel commentModel = listModel.get(i) ;
						respObject.put(new JSONObject()
							.put("result" , 0)
							.put("commentId" , commentModel.getComment_id())
							.put("commentContent", commentModel.getComment_content())
							.put("commentDate", commentModel.getComment_date())
							.put("responseContent", commentModel.getResponse_content())
							.put("responseDate", commentModel.getResponse_date())
							.put("commentUser", commentModel.getUser_name())
							.put("userTx", commentModel.getUser_touxiang())) ;
					}
				}
			}  else if (action.equals("addComment")) {
				CommentModel commentModel = new CommentModel() ;
				commentModel.setComment_content(reqObject.getJSONObject(0).getString("commentContent")) ;
				commentModel.setComment_date(reqObject.getJSONObject(0).getString("commentDate")) ;
				commentModel.setUser_id(reqObject.getJSONObject(0).getInt("userId")) ;
				commentModel.setNote_id(reqObject.getJSONObject(0).getInt("noteId")) ;
				commentModel.setResponse_content("") ;
				commentModel.setResponse_date("") ;
				
				String flag = mns.addComment(commentModel) ;
				
				if (!flag.equals("ok")) {//保存失败
					respObject = new JSONArray().put(new JSONObject().put("result" , -1)) ;
				} else {
					respObject = new JSONArray().put(new JSONObject().put("result" , 0)) ;
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
