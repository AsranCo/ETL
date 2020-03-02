update msisdn_us_9122591237
inner JOIN App on app_layer=App.`key`
set msisdn_us_9122591237.app_layer=App.value
where app_layer=`key`;



select app_layer from msisdn_us_9122591237 group by app_layer;

select count(*) from msisdn_hrequest_tbl
