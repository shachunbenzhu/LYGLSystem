package com.cn.ncist.rq.destination.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cn.ncist.rq.Tools.ConvertCharacter;
import com.cn.ncist.rq.action.base.BaseAction;
import com.cn.ncist.rq.page.vo.PageBean;
import com.cn.ncist.rq.province.vo.NationModel;
import com.cn.ncist.rq.province.vo.ProvinceModel;

@SuppressWarnings("serial")
public class ManagerDestinationAction extends BaseAction {

	private PageBean pageBean = null;
	private int page; // 用户提交的当前页数
	
	private String destination_ids;
	private String destination_infos;
	
	private String destination_name_select;
	private String province_name_select;
	
	private String destination_name_add ;
	private String destination_pinyin_add ;
	private int destination_number_add ;
	private String province_name_add ;
	private String nation_name_add ;
	
	private List<ProvinceModel> allProvinceName;
	private List<NationModel> allNationName;
	private Map<Integer,List<ProvinceModel>> allProNameByNati = new HashMap<Integer, List<ProvinceModel>>() ;
	
	private String flag = null;

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

	public String getDestination_ids() {
		return destination_ids;
	}

	public void setDestination_ids(String destinationIds) {
		destination_ids = destinationIds;
	}

	public String getDestination_infos() {
		return destination_infos;
	}

	public void setDestination_infos(String destinationInfos) {
		destination_infos = destinationInfos;
	}

	public String getDestination_name_select() {
		return destination_name_select;
	}

	public void setDestination_name_select(String destinationNameSelect) {
		destination_name_select = destinationNameSelect;
	}

	public String getProvince_name_select() {
		return province_name_select;
	}

	public void setProvince_name_select(String provinceNameSelect) {
		province_name_select = provinceNameSelect;
	}

	public List<ProvinceModel> getAllProvinceName() {
		return allProvinceName;
	}

	public void setAllProvinceName(List<ProvinceModel> allProvinceName) {
		this.allProvinceName = allProvinceName;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getDestination_name_add() {
		return destination_name_add;
	}

	public void setDestination_name_add(String destinationNameAdd) {
		destination_name_add = destinationNameAdd;
	}

	public String getDestination_pinyin_add() {
		return destination_pinyin_add;
	}

	public void setDestination_pinyin_add(String destinationPinyinAdd) {
		destination_pinyin_add = destinationPinyinAdd;
	}

	public int getDestination_number_add() {
		return destination_number_add;
	}

	public void setDestination_number_add(int destinationNumberAdd) {
		destination_number_add = destinationNumberAdd;
	}

	public String getProvince_name_add() {
		return province_name_add;
	}

	public void setProvince_name_add(String provinceNameAdd) {
		province_name_add = provinceNameAdd;
	}

	public String getNation_name_add() {
		return nation_name_add;
	}

	public void setNation_name_add(String nationNameAdd) {
		nation_name_add = nationNameAdd;
	}
	
	public List<NationModel> getAllNationName() {
		return allNationName;
	}

	public void setAllNationName(List<NationModel> allNationName) {
		this.allNationName = allNationName;
	}

	public Map<Integer, List<ProvinceModel>> getAllProNameByNati() {
		return allProNameByNati;
	}

	public void setAllProNameByNati(
			Map<Integer, List<ProvinceModel>> allProNameByNati) {
		this.allProNameByNati = allProNameByNati;
	}

	@Override
	public String execute() throws Exception { // 分页查询所有Destination
		String hql = "select dm.destination_id, dm.destination_name, dm.destination_pinyin, dm.destination_number, " +
				"dm.destination_img , pm.province_name, nm.nation_name from DestinationModel dm, ProvinceModel pm, NationModel nm " +
				"where pm.province_id = dm.province_id and dm.nation_id = nm.nation_id order by dm.destination_id";
		commonMethod(hql , 1);
		return "success";
	}

	public void commonMethod(String hql , int flag) throws Exception {
		allProvinceName = managerProvinceService.queryProvince();	
		allNationName = managerProvinceService.queryNation() ;
		
		for(int i = 0; i < allNationName.size(); i++) {
			Integer keyString = allNationName.get(i).getNation_id() ;
			List<ProvinceModel> valueList = managerProvinceService.queryProvinceByNation(keyString) ;
			allProNameByNati.put(keyString, valueList) ;
		}
		
		pageBean = pageService.queryPageDestination(hql, 10, page, "DestinationModel" , flag);
	}

	public String queryDestination() throws Exception {
		//destination_name_select = ConvertCharacter.Convert(destination_name_select) ;
		
		String hql = "select dm.destination_id, dm.destination_name, dm.destination_pinyin, dm.destination_number, " +
				"dm.destination_img , pm.province_name, nm.nation_name from DestinationModel dm, ProvinceModel pm, NationModel nm " +
				"where pm.province_id = dm.province_id and dm.nation_id = nm.nation_id" ;
		
		if(destination_name_select != null) {
			hql = hql + " and dm.destination_name like '%" ;
			hql = hql + destination_name_select.trim();
			hql = hql + "%'" ;
		} 
		if(!province_name_select.equals(String.valueOf(-1))) {
			int province_id = managerProvinceService.queryProvinceIdByName(province_name_select) ;
			hql = hql + " and dm.province_id = " ;
			hql = hql + province_id;
		}
		hql = hql + " order by dm.destination_id" ;
		commonMethod(hql , 1);
		return "success";
	}

	public String deleteDestination() throws Exception {
		if (destination_ids != null && !"".equals(destination_ids.trim())) {
			String[] nids = destination_ids.split(";");
			if (nids.length > 0) {
				for (int i = 0; i < nids.length; i++) {
					flag = managerDestinationService.deleteDestination(Integer
							.valueOf(nids[i]));
				}
			}
		}
		if (flag.equals("ok")) {
			String hql = "select dm.destination_id, dm.destination_name, dm.destination_pinyin, dm.destination_number, " +
				"dm.destination_img , pm.province_name, nm.nation_name from DestinationModel dm, ProvinceModel pm, NationModel nm " +
				"where pm.province_id = dm.province_id and dm.nation_id = nm.nation_id order by dm.destination_id";
			commonMethod(hql , 1);
			return "success";
		} else {
			addActionError("删除失败");
			return "failure";
		}
	}

	public String updateDestination() throws Exception {
		if (destination_infos != null && !"".equals(destination_infos.trim())) {
			String[] ninfos = destination_infos.split(";");
			if (ninfos.length > 0) {
				//String a = ConvertCharacter.Convert(ninfos[1]) ;
				flag = managerDestinationService.updateDestination(
						Integer.valueOf(ninfos[0]), ConvertCharacter.Convert(ninfos[1]), ConvertCharacter.Convert(ninfos[2]),
						Integer.valueOf(ninfos[3]), ConvertCharacter.Convert(ninfos[4]), ConvertCharacter.Convert(ninfos[5]));
			}
		}
		if (flag.equals("ok")) {
			String hql = "select dm.destination_id, dm.destination_name, dm.destination_pinyin, dm.destination_number, " +
				"dm.destination_img , pm.province_name, nm.nation_name from DestinationModel dm, ProvinceModel pm, NationModel nm " +
				"where pm.province_id = dm.province_id and dm.nation_id = nm.nation_id order by dm.destination_id";
			commonMethod(hql , 1);
			return "success";
		} else {
			addActionError("修改失败");
			return "failure";
		}
	}
	

	public String addDestination() throws Exception { 
		destination_name_add = ConvertCharacter.Convert(destination_name_add) ;
		province_name_add = ConvertCharacter.Convert(province_name_add) ;
		nation_name_add = ConvertCharacter.Convert(nation_name_add) ;
		
		flag = managerDestinationService.addDestination(destination_name_add, destination_pinyin_add, destination_number_add,
						province_name_add, nation_name_add) ;
		if (flag.equals("ok")) { 
			String hql = "select dm.destination_id, dm.destination_name, dm.destination_pinyin, dm.destination_number, " +
				"dm.destination_img , pm.province_name, nm.nation_name from DestinationModel dm, ProvinceModel pm, NationModel nm " +
				"where pm.province_id = dm.province_id and dm.nation_id = nm.nation_id order by dm.destination_id";
			commonMethod(hql , 1);
			return "success" ; 
		} else { 
			addActionError("添加失败") ; 
			return "failure" ; 
		} 
	}
}
