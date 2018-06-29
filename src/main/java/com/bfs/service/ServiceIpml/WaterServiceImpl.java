package com.bfs.service.ServiceIpml;

import com.bfs.entity.Water;
import com.bfs.mapper.WaterMapper;
import com.bfs.service.WaterService;
import com.bfs.util.ExcelUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
@Service
public class WaterServiceImpl implements WaterService {
    @Autowired
    private WaterMapper waterMapper;

    /**
     * 导入excel数据到数据库
     * @param file
     * @throws Exception
     */
    @Override
    public void addWaterList(MultipartFile file) throws Exception {
        List<Water> waterList = new ArrayList<>();
        InputStream in = file.getInputStream();
        List<List<Object>> listob = new ExcelUtil().getBankListByExcel(in, file.getOriginalFilename());
        in.close();
//        System.out.println("!!!!!!!!!!!!!!!!!!!!" + "开始遍历");
        //遍历listob数据，把数据放到List中
        for (int i = 0; i < listob.size(); i++) {
//            System.out.println("########Size"+listob.size());
//            System.out.println("第"+ i +"个数值"+listob.get(i));
            List<Object> ob = listob.get(i);
            Water water = new Water();
//            System.out.println("##################ob.listSize"+ob.size());
//            System.out.println("水位的值"+ob.get(0).toString());
//            System.out.println("流量的值"+ob.get(1).toString());
            water.setWater_depth(ob.get(0).toString());
            water.setFlow(ob.get(1).toString());
            water.setArea(ob.get(2).toString());
            water.setVolicity(ob.get(3).toString());
            water.setRemark(ob.get(4).toString());
            waterList.add(water);
//            System.out.println(water.toString());

        }
//        System.out.println(waterList);
        waterMapper.addWater(waterList);
    }

    /**
     * pageHelper分页
     * @param pageNow
     * @param waterDepth
     * @return
     */
    @Override
    public PageInfo<Water> getWaterListWithPage(Integer pageNow,String waterDepth) {
        pageNow = (pageNow==null)?1:pageNow;
        PageHelper.startPage(pageNow,25);
        List<Water> list = waterMapper.getWaterList(waterDepth);
        PageInfo<Water> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 修改数据
     * @param water
     * @return
     */
    @Override
    public int updateWater(Water water) {
        return waterMapper.updateWater(water);
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    @Override
    public Water selectById(Integer id) {
        return waterMapper.selectById(id);
    }
}