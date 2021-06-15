mvn exec:java -Dexec.mainClass="de.qytera.suite_crm.TestRunner" \
  -Ddriver.name="edge-remote" \
  -DpageUrl="http://suitecrm:8080" \
  -Ddriver.remoteUrl="http://20.79.68.46:4446/wd/hub"
