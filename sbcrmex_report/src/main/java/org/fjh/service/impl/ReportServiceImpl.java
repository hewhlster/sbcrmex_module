package org.fjh.service.impl;

import org.fjh.dao.ReportMapper;
import org.fjh.service.IReportService;
import org.fjh.util.PageEntity;
import org.fjh.util.higtchart.HighCharts;
import org.fjh.util.higtchart.Serie;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.*;

@Service
@Component
public class ReportServiceImpl extends BaseServiceImpl<Object> implements IReportService {

    private ReportMapper mapper;

    @Autowired
    public void setMapper(ReportMapper mapper) {
        super.setBaseMapper(mapper);
        this.mapper = mapper;
    }

    @Override
    public PageEntity<Object> customerComposePager(PageEntity<Object> pageEntity) {
		/*Page page=PageHelper.startPage(pageEntity.getPageNumber(), pageEntity.getPageSize());
		List rows=mapper.cutomerComposeListPage();
		pageEntity.setRows(rows);
		Long total =page.getTotal();
		pageEntity.setTotal(total.intValue());
		return pageEntity;	*/
        return null;

    }


    @Override
    public List customerComposeData() {
		/*List rows=mapper.cutomerComposeListPage();
		ArrayList ret_list = new ArrayList<>();
		for(Object temp:rows){
			Map map = (Map)temp;
			Map<String,Object> ret_map = new HashMap<String, Object>();
			//highcharts 数据区域标签名
			ret_map.put("tname",map.get("tname"));
			//highcharts y轴数据(带小数点)
			ret_map.put("y", ((Long)map.get("cnt"))/(rows.size()+0.0));
			ret_list.add(ret_map);
		}
		
		return ret_list;*/
        return null;
    }

    /**
     * datas=[
     * {name:"增加中型客户","data":[10,10],stack:"new"},
     * {name:"增加大客户","data":[1,2],stack:"new"},
     * {name:"增加优质客户","data":[4,6],stack:"new"},
     * {name:"流失中型客户","data":[3,9],stack:"losed"},
     * {name:"流失大客户","data":[8,12],stack:"losed"},
     * {name:"流失优质客户","data":[9,7],stack:"losed"},
     * ];
     */

    @Override
    public List<Object> reportCustomerNewLosed(Date bdate, Date edate) {
		/*List<Object> list=mapper.getNewCustomer(bdate, edate);
		List<Map>    rlist = new ArrayList<>();
		
		for(Object o:list){
			Map m = (Map)o;
			Map n = new HashMap<>();
			n.put("name", m.get("name"));
			n.put("data", m.get("cnt"));
			n.put("stack", m.get("stack"));

			rlist.add(n);
		}
		
		list=mapper.getLosedCustomer(bdate, edate);
		for(Object o:list){
			Map map = (Map)o;
			map.get("name");
			map.get("cnt");
		}
		*/


        return null;
    }

    @Override
    public HighCharts reportServiceCompose(Date bdate, Date edate) {
		
/*		cnt	tname	month
		1	投诉	6
		1	建议	6
		1	咨询	6
		1	投诉	7
		1	咨询	7*/
        // ==>
        /*
         * [{name:'咨询',data:[1,1]},
         * {name:'建议',data:[1,0]},
         * {name:'投诉',data:[1,1]}]
         *
         *
         * */
        List<Object> list = new ArrayList<>();//mapper.reportServiceCompose(6, 7);
        Map<String, List<Object>> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            Map mt1 = (Map) list.get(i);
            List alist = new ArrayList();
            alist.add((mt1.get("cnt")));
            map.put((String) mt1.get("tname"), alist);

            for (int j = i + 1; j < list.size(); j++) {
                Map mt2 = (Map) list.get(j);
                if (((String) mt2.get("tname")).equals(((String) mt1.get("tname")))) {
                    alist = map.get((String) mt1.get("tname"));
                    alist.add((mt2.get("cnt")));
                    list.remove(j);
                }
            }
        }

        HighCharts chart = new HighCharts();
        chart.getTitle().setText("服务类型比率(2019/01-2019/04)");
        chart.getxAxis().setCategories(Arrays.asList(new String[]{"2019/01", "2019/02"}));

        List<Serie> series = chart.getSeries();

        Set<String> keySet = map.keySet();
        for (String t : keySet) {
            Serie s = new Serie();
            s.setName(t);
            s.setData(map.get(t));
            series.add(s);
        }

        chart.setSeries(series);
        return chart;
    }


    @Override
    public HighCharts reportServiceSatisfy(Date bdate, Date edate) {
        /**
         * tname	month	satisfy
         投诉	6	3.0000
         建议	6	4.0000
         投诉	7	5.0000
         咨询	7	4.0000

         ==>
         * [{name:'咨询',data:[1,1]},
         * {name:'建议',data:[1,0]},
         * {name:'投诉',data:[1,1]}]

         */
        List<Object> list = new ArrayList<>();//mapper.reportServiceSatisfy(6, 7);
        Map<String, List<Object>> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            Map mt1 = (Map) list.get(i);
            List alist = new ArrayList();
            alist.add((mt1.get("satisfy")));
            map.put((String) mt1.get("tname"), alist);

            for (int j = i + 1; j < list.size(); j++) {
                Map mt2 = (Map) list.get(j);
                if (((String) mt2.get("tname")).equals(((String) mt1.get("tname")))) {
                    alist = map.get((String) mt1.get("tname"));
                    alist.add((mt2.get("satisfy")));
                    list.remove(j);
                }
            }
        }

        HighCharts chart = new HighCharts();
        chart.getTitle().setText("服务满意度(2019/01-2019/04)");
        chart.getxAxis().setCategories(Arrays.asList(new String[]{"2019/01", "2019/02"}));

        List<Serie> series = chart.getSeries();

        Set<String> keySet = map.keySet();
        for (String t : keySet) {
            Serie s = new Serie();
            s.setName(t);
            s.setData(map.get(t));
            series.add(s);
        }

        chart.setSeries(series);
        return chart;
    }


    @Override
    public HighCharts reportCompletionDegree(Date bdate, Date edate) {
        /**
         tname	month	cnt
         投诉	6	1
         建议	6	2
         咨询	7	1
         投诉	7	1
         ==>
         * [{name:'咨询',data:[1,1]},
         * {name:'建议',data:[1,0]},
         * {name:'投诉',data:[1,1]}]

         */
        List<Object> list =new ArrayList<>();// mapper.reportCompletionDegree(6, 7);
        Map<String, List<Object>> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            Map mt1 = (Map) list.get(i);
            List alist = new ArrayList();
            alist.add((mt1.get("cnt")));
            map.put((String) mt1.get("tname"), alist);

            for (int j = i + 1; j < list.size(); j++) {
                Map mt2 = (Map) list.get(j);
                if (((String) mt2.get("tname")).equals(((String) mt1.get("tname")))) {
                    alist = map.get((String) mt1.get("tname"));
                    alist.add((mt2.get("cnt")));
                    list.remove(j);
                }
            }
        }

        HighCharts chart = new HighCharts();
        chart.getTitle().setText("服务完成数量(2019/01-2019/04)");
        chart.getxAxis().setCategories(Arrays.asList(new String[]{"2019/01", "2019/02"}));

        List<Serie> series = chart.getSeries();

        Set<String> keySet = map.keySet();
        for (String t : keySet) {
            Serie s = new Serie();
            s.setName(t);
            s.setData(map.get(t));
            series.add(s);
        }

        chart.setSeries(series);
        return chart;
    }

}
