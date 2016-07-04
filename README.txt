#==============================================================================
# Java VM System Property 설정
#==============================================================================
# Spring Profile Active 설정
-Dspring.profiles.active="dev,jdbc,mybatis,jpa"
# log4j logging 설정
-Dlog4j.configurationFile="logs/local/log4j2.xml"
# logback logging 설정
-Dlogback.configurationFile="logs/local/logback.xml"
# log file path & file name
-Dlogs.dir="d:\n-root\log"
-Dapp.name="application"
# serve run-time 환경
-Dserver.type="local"

# log4j에 대한 환경 설정파일을 시스템 퍼라퍼티로 설정하는 경우
-Dlog4j.configurationFile=path/to/log4j2.xml

# logback 대한 환경 설정파일을 시스템 퍼라퍼티로 설정하는 경우
-Dlogback.configurationFile=/path/to/config.xml

# 개발 서버
-Dspring.profiles.active="dev,mybatis" -Dlog4j.configurationFile="logs/local/log4j2.xml" -Dlogback.configurationFile="logs/local/logback.xml" -Dlogs.dir="d:\n-root\log" -Dapp.name="application" -Dserver.type="local"

-Dspring.profiles.active=dev,jdbc,mybatis,jpa -Dlog4j.configurationFile=logs/local/log4j2.xml -Dlogback.configurationFile=logs/local/logback.xml -Dlogs.dir=d:\n-root\log -Dapp.name=webapp -Dserver.type=local

# 운영 서버
-Dspring.profiles.active="production,mybatis" -Dlog4j.configurationFile="logs/op/log4j2.xml" -Dlogback.configurationFile="logs/op/logback.xml" -Dlogs.dir="d:\n-root\log" -Dapp.name="application" -Dserver.type="op"

#==============================================================================
# Cloud Foundry 설정
#==============================================================================
# manifest.yml을 작업 환경에 맞게 설정하여 CF환경에 push한다.
# datasource는 Spring Profile에 맞게 resources/properties, datasource-single-config.xml DB환경에 맞게 설정한다.
# http://domain/sample/index.html 페이지 좌측 Grid > uiGrid > [PPAS] CRUD Grid, [MySQL] CRUD Grid 메뉴로 datasource에 설정된 ppas, mysql DB를 테스트한다.


