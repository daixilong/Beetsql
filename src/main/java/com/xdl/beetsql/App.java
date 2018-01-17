package com.xdl.beetsql;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.StringTemplateResourceLoader;
import org.beetl.sql.core.ClasspathLoader;
import org.beetl.sql.core.ConnectionSource;
import org.beetl.sql.core.ConnectionSourceHelper;
import org.beetl.sql.core.DefaultNameConversion;
import org.beetl.sql.core.IDAutoGen;
import org.beetl.sql.core.Interceptor;
import org.beetl.sql.core.SQLLoader;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.UnderlinedNameConversion;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.core.db.OracleStyle;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.ext.DebugInterceptor;

import com.xdl.beetsql.model.SysUser;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	/**
    	 * 配置相关的数据库的链接
    	 * 
    	 */
        ConnectionSource source=ConnectionSourceHelper.getSimple("oracle.jdbc.OracleDriver", "jdbc:oracle:thin:@192.168.0.8:1521:urp", "xggl_v2", "xggl_v2");
        UnderlinedNameConversion nc = new  UnderlinedNameConversion();
       // DefaultNameConversion  nc=new DefaultNameConversion();
        SQLLoader loader=new ClasspathLoader("/sql");
        DBStyle sbStyle=new OracleStyle();
        SQLManager sqlManager=new SQLManager(sbStyle, loader,source,nc,new Interceptor[]{new DebugInterceptor()});
        sqlManager.addIdAutonGen("uuid2", new IDAutoGen() {

					public Object nextID(String params) {
						// TODO Auto-generated method stub
						return new Random().nextInt(100);
					}
        	
				});
        /**
         * 自动生成对应的pojo对象
         */
       //sqlManager.genPojoCodeToConsole("SYS_USER");
       //sqlManager.genSQLTemplateToConsole("SYS_USER");
        //添加当前用户的相关信息
        /*SysUser  sysUser=new SysUser();
        sysUser.setsName("d");
        sqlManager.insert(sysUser);*/
       // List<SysUser> list= sqlManager.query(SysUser.class).select();
   /*     SysUser user=new SysUser();
        user.setsId(17);
        List<SysUser> list=sqlManager.select("SysUser.sample", SysUser.class, user);
        for (SysUser sysUser : list) {
					System.out.println("----"+sysUser.getsId()+"----"+sysUser.getsName());
				}*/
        PageQuery query=new PageQuery(1, 2);
        sqlManager.pageQuery("SysUser.sample", SysUser.class, query);
        List<SysUser> sysUsers=  query.getList();
        for (SysUser sysUser : sysUsers) {
					 System.out.println("----"+sysUser.getsId()+"----"+sysUser.getsName());
				}
    	
    }
}
