mvn exec:java -Dexec.mainClass="de.qytera.suite_crm.TestRunner" \
  -Ddriver.name="opera-remote" \
  -DpageUrl="http://suitecrm:8080" \
  -Ddriver.remoteUrl="http://20.79.80.146:4446/wd/hub"
