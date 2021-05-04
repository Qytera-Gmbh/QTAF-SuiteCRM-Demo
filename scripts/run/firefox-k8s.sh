mvn exec:java -Dexec.mainClass="de.qytera.suite_crm.TestRunner" \
  -Ddriver.name="firefox-remote" \
  -DpageUrl="http://suitecrm:8080" \
  -Ddriver.remoteUrl="http://20.79.81.77:4445/wd/hub"
