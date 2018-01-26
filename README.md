# Beetsql
新的模板引擎（包含数据库，整合了mybatis和hibernate的优点）
# 自动生成pojo以及dao
String table = "user_test";
String entityPkg = "xxx.xxx.entity";
String daoPkg = "xxx.xxx.dao";
GenConfig config = new GenConfig();	   	
MapperCodeGen mapper = new MapperCodeGen(daoPkg);
config.codeGens.add(mapper);
sqlMnager.genPojoCode(table, entityPkg, config);
sqlMnager.genSQLFile(table);
