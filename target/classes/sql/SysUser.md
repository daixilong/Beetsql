sample
===
* ×¢ÊÍ

	select #use("cols")# from SYS_USER  where  #use("condition")#

sample$count
===
   select count(1) from SYS_USER  where  #use("condition")#

cols
===
	S_ID,S_NAME

updateSample
===
	
	S_ID=#sId#,S_NAME=#sName#

condition
===

	1 = 1  
	@if(!isEmpty(sId)){
	 and S_ID=#sId#
	@}
	@if(!isEmpty(sName)){
	 and S_NAME=#sName#
	@}
	