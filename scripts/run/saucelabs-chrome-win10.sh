mvn exec:java -Dexec.mainClass="de.qytera.suite_crm.TestRunner" \
  -Ddriver.name="sauce" \
  -Ddriver.remoteUrl="https://ondemand.eu-central-1.saucelabs.com/wd/hub" \
  -Dsauce.browserName="chrome"
  -Ddriver.version="latest" \
  -Ddriver.platform="Windows 10" \
  -DpageUrl="http://suitecrm-demo.eba-xfgdbnjt.eu-central-1.elasticbeanstalk.com"
