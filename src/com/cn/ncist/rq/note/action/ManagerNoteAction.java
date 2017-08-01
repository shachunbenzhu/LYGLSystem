package com.cn.ncist.rq.note.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.cn.ncist.rq.Tools.ConvertCharacter;
import com.cn.ncist.rq.action.base.BaseAction;
import com.cn.ncist.rq.note.vo.CommentModel;
import com.cn.ncist.rq.note.vo.NoteModel;
import com.cn.ncist.rq.page.vo.PageBean;

public class ManagerNoteAction extends BaseAction implements ServletRequestAware {

	private PageBean pageBean = null;
	private int page; // �û��ύ�ĵ�ǰҳ��
	private String note_ids;
	private String note_infos;
	private List<NoteModel> noteModelList = null;
	private Integer note_id;
	private Integer user_id;
	private String note_title_select;
	private String note_address_select;
	private Integer note_days_select;
	private List<NoteModel> allNoteDays;
	private List<NoteModel> allNoteAddress;
	//private HashMap<String, String> allNoteImg = new HashMap<String, String>();
	private List<String> allNoteImg = new ArrayList<String>() ;
	private String flag = null;

	//�ϴ��ļ�����
	private File note_bgimg_new ;//�����ϴ��ļ�����
	private String uploadContentType ;//�����ϴ��ļ�����
	private String uploadFileName ;//�����ϴ��ļ���
	private String savePath ;//��������ע�����
	
	private Integer comment_id;
	private List<CommentModel> allComment ;
	
	private HttpServletRequest request ;//implements ServletRequestAware
	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getNote_ids() {
		return note_ids;
	}

	public void setNote_ids(String noteIds) {
		note_ids = noteIds;
	}

	public String getNote_infos() {
		return note_infos;
	}

	public void setNote_infos(String noteInfos) {
		note_infos = noteInfos;
	}

	public List<NoteModel> getNoteModelList() {
		return noteModelList;
	}

	public void setNoteModelList(List<NoteModel> noteModelList) {
		this.noteModelList = noteModelList;
	}
	
	public String getNote_title_select() {
		return note_title_select;
	}

	public void setNote_title_select(String noteTitleSelect) {
		note_title_select = noteTitleSelect;
	}

	public List<NoteModel> getAllNoteDays() {
		return allNoteDays;
	}

	public void setAllNoteDays(List<NoteModel> allNoteDays) {
		this.allNoteDays = allNoteDays;
	}

	public List<NoteModel> getAllNoteAddress() {
		return allNoteAddress;
	}

	public void setAllNoteAddress(List<NoteModel> allNoteAddress) {
		this.allNoteAddress = allNoteAddress;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public String getNote_address_select() {
		return note_address_select;
	}

	public void setNote_address_select(String noteAddressSelect) {
		note_address_select = noteAddressSelect;
	}

	public Integer getNote_id() {
		return note_id;
	}

	public Integer getNote_days_select() {
		return note_days_select;
	}

	public void setNote_days_select(Integer noteDaysSelect) {
		note_days_select = noteDaysSelect;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer userId) {
		user_id = userId;
	}

	public void setNote_id(Integer noteId) {
		note_id = noteId;
	}

	public List<String> getAllNoteImg() {
		return allNoteImg;
	}

	public void setAllNoteImg(List<String> allNoteImg) {
		this.allNoteImg = allNoteImg;
	}

	public File getNote_bgimg_new() {
		return note_bgimg_new;
	}

	public void setNote_bgimg_new(File noteBgimgNew) {
		note_bgimg_new = noteBgimgNew;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public Integer getComment_id() {
		return comment_id;
	}

	public void setComment_id(Integer commentId) {
		comment_id = commentId;
	}

	public List<CommentModel> getAllComment() {
		return allComment;
	}

	public void setAllComment(List<CommentModel> allComment) {
		this.allComment = allComment;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request ;
		
	}
	@SuppressWarnings("deprecation")
	public String getSavePath() throws Exception {
		return ServletActionContext.getRequest().getRealPath(savePath);
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	@Override
	public String execute() throws Exception { // ��ҳ��ѯ����Note
		// pageBean = managerNoteService.queryAllNote() ;
		String hql = "select nm.note_id, nm.note_title, nm.note_date, nm.note_days, nm.note_expend, " +
				"um.user_name, nm.note_address, nm.note_zannumber, nm.note_seenumber, " +
				"nm.note_commentnumber from NoteModel nm, UserModel um where nm.user_id = um.user_id order by nm.note_id";
		commonMethod(hql , 1);
		return "success";
	}

	public void commonMethod(String hql , int flag) throws Exception {
		//������ֻ��ѯ�����ֶΣ�ǰ̨�е�List�����һ��ʵ�壬��ѯ�����ֶεõ�����Object
		allNoteAddress = managerNoteService.queryNote();	
		NoteModel m= new NoteModel();
		/*m.setNote_id(4);
		m.setNote_address(allNoteAddress.get(0).toString());
		allNoteAddress.add(m);
		m=allNoteAddress.get(1);*/
		allNoteDays = managerNoteService.queryNote();
		pageBean = pageService.queryPageNote(hql, 10, page, "NoteModel" , flag);
		/*Integer ro = pageBean.getAllRow() ;
		List list = pageBean.getList() ;
		request.setAttribute("note", pageBean.getList()) ;*/
	}

	public String queryNote() throws Exception {
		//�����������
		/*note_title_select = ConvertCharacter.Convert(note_title_select) ;
		note_address_select = ConvertCharacter.Convert(note_address_select) ;*/
		
		
		//ע�⣬��֮ǰû��where�����ȼ�һ��where 1=1�������Ͳ���Ҫ�ж��Ƿ��and
		//���˶��������������ĺͲ�ѯȫ��һ��
		String hql = "select nm.note_id, nm.note_title, nm.note_date, nm.note_days, nm.note_expend, " +
				"um.user_name, nm.note_address, nm.note_zannumber, nm.note_seenumber, " +
				"nm.note_commentnumber from NoteModel nm, UserModel um where nm.user_id = um.user_id" ;
		
		//�ַ���ȥ�ո�
		if(note_title_select != null) {
			hql = hql + " and nm.note_title like '%" ;
			hql = hql + note_title_select.trim();
			hql = hql + "%'" ;
		} 
		if(!note_address_select.equals(String.valueOf(-1))) {
			hql = hql + " and nm.note_address = '" ;
			hql = hql + note_address_select;
			hql = hql + "'" ;
		}
		if(note_days_select != (-1)) {
			hql = hql + " and nm.note_days = " ;
			hql = hql + note_days_select;
		}
		hql = hql + " order by nm.note_id" ;
		/*String hql = "select nm from NoteModel nm where nm.note_title like '%";
		hql = hql + note_title_select;
		hql = hql + "%' and nm.note_address = '";
		hql = hql + note_address;
		hql = hql + "' and nm.note_days =";
		hql = hql + note_days ;*/
		commonMethod(hql , 1);
		return "success";
	}

	public String queryUserNote() throws Exception {
		String hql = "select nm.note_id, nm.note_title, nm.note_date, nm.note_days, nm.note_expend, " +
				"um.user_name, nm.note_address, nm.note_zannumber, nm.note_seenumber, " +
				"nm.note_commentnumber from NoteModel nm, UserModel um where nm.user_id = um.user_id " +
				"and um.user_id = " + user_id;
		commonMethod(hql , 1);
		return "success";
	}
	
	public String queryNoteDetile() throws Exception {
		noteModelList = managerNoteService.queryNoteDetile(note_id) ;
		String[] note_img1 = noteModelList.get(0).getNote_img().split(";") ;
		//String[] note_img_desc1 = noteModelList.get(0).getNote_img_desc().split(";") ;
		for(int i = 0; i < note_img1.length; i++){                      //�����ַ�������	
			//allNoteImg.put(note_img1[i], note_img_desc1[i]) ;
			allNoteImg.add(note_img1[i]) ;
		}
		return "success";
	}

	public String deleteNote() throws Exception {
		if (note_ids != null && !"".equals(note_ids.trim())) {
			String[] nids = note_ids.split(";");
			if (nids.length > 0) {
				for (int i = 0; i < nids.length; i++) {
					flag = managerNoteService.deleteNote(Integer
							.valueOf(nids[i]));
				}
			}
		}
		if (flag.equals("ok")) {
			String hql = "select nm.note_id, nm.note_title, nm.note_date, nm.note_days, nm.note_expend, " +
				"um.user_name, nm.note_address, nm.note_zannumber, nm.note_seenumber, " +
				"nm.note_commentnumber from NoteModel nm, UserModel um where nm.user_id = um.user_id order by nm.note_id";
			commonMethod(hql , 1);
			return "success";
		} else {
			addActionError("ɾ��ʧ��");
			return "failure";
		}
	}
	
	public String updateNoteDetile() throws Exception {
		
		//�Է��������ļ������ַ��ԭ�ļ��������ϴ��ļ������
		FileOutputStream fos = new FileOutputStream(getSavePath() + "\\" + getUploadFileName()) ;
		//���ϴ��ļ�����һ���ļ��ϴ���
		FileInputStream fis = new FileInputStream(getNote_bgimg_new()) ;
		//���ϴ��ļ�������д�������
		byte[] buffer = new byte[1024] ;
		int len = 0 ;
		while((len = fis.read(buffer)) > 0) {
			fos.write(buffer, 0, len) ;
		}
		
		if (note_infos != null && !"".equals(note_infos.trim())) {
			String[] ninfos = note_infos.split(";");
			if (ninfos.length > 0) {
				/*flag = managerNoteService.updateNote(
						Integer.valueOf(ninfos[0]), ConvertCharacter.Convert(ninfos[1]), 
						ConvertCharacter.Convert(ninfos[2]), Integer.valueOf(ninfos[3]), 
						Double.valueOf(ninfos[4]), ConvertCharacter.Convert(ninfos[5]), 
						Integer.valueOf(ninfos[6]), Integer.valueOf(ninfos[7]),
						Integer.valueOf(ninfos[8]), ConvertCharacter.Convert(ninfos[9]));*/
			}
		}
		if (flag.equals("ok")) {
			noteModelList = managerNoteService.queryNoteDetile(note_id) ;
			String[] note_img1 = noteModelList.get(0).getNote_img().split(";") ;
			//String[] note_img_desc1 = noteModelList.get(0).getNote_img_desc().split(";") ;
			for(int i = 0; i < note_img1.length; i++){                      //�����ַ�������	
				//allNoteImg.put(note_img1[i], note_img_desc1[i]) ;
			}
			return "success";
		} else {
			addActionError("�޸�ʧ��");
			return "failure";
		}
	}


	/*
	 * public String addNote() throws Exception { if () { return "success" ; }
	 * else { addActionError("") ; return "failure" ; } }
	 */
	
	
	/* ***********************************************���۹���********************************************* */
	public String queryAllComment() throws Exception { // ��ҳ��ѯ����Comment
		queryNoteDetile() ;
		allComment = managerNoteService.queryAllComment(note_id) ;
		return "success";
	}
	
	public String deleteComment() throws Exception {
		//������ɾ������ǰ�Ȳ�ѯ�μ�ID��������ֻ��һ�����ۣ���ɾ�����ѯ�����μ�ID�����μ�ID����ѯ���ۺ��μ�����ʹ��
		note_id = managerNoteService.queryNoteIdByCommentId(comment_id) ;
		flag = managerNoteService.deleteComment(comment_id);
		
		if (flag.equals("ok")) {
			queryAllComment() ;
			return "success";
		} else {
			addActionError("ɾ��ʧ��");
			return "failure";
		}
	}
}
