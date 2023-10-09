mvn clean compile

# Test groups
mvn test -Ddriver.headless=1 -Dgroups=login
mvn test -Ddriver.headless=1 -Dgroups=login,calls
mvn test -Ddriver.headless=1 -Dgroups=login,contacts
mvn test -Ddriver.headless=1 -Dgroups=login,meetings
mvn test -Ddriver.headless=1 -Dgroups=login,tasks

# Test features
mvn test -Ddriver.headless=1 -Dtest=Logintest
mvn test -Ddriver.headless=1 -Dtest=LoginTest,CallsTest
mvn test -Ddriver.headless=1 -Dtest=LoginTest,ContactsTest
mvn test -Ddriver.headless=1 -Dtest=LoginTest,MeetingsTest
mvn test -Ddriver.headless=1 -Dtest=LoginTest,TasksTest

# Test scenarios
mvn test -Ddriver.headless=1 -Dtest=Logintest#testLogin
mvn test -Ddriver.headless=1 -Dtest=LoginTest,CallsTest#testCalls
mvn test -Ddriver.headless=1 -Dtest=LoginTest,ContactsTest#testContacts
mvn test -Ddriver.headless=1 -Dtest=LoginTest,MeetingsTest#testMeetings
mvn test -Ddriver.headless=1 -Dtest=LoginTest,TasksTest#testTasks