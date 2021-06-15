mvn exec:java -Dexec.mainClass="de.qytera.suite_crm.TestRunner" \
  -Ddriver.name="firefox-remote" \
  -DpageUrl="http://suitecrm:8080" \
  -Ddriver.remoteUrl="http://20.79.115.186:4445/wd/hub"
