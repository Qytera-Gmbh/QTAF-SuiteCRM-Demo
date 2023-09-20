mvn clean compile

# Test groups
mvn test -Dgroups=login
mvn test -Dgroups=login,calls
mvn test -Dgroups=login,contacts
mvn test -Dgroups=login,meetings
mvn test -Dgroups=login,tasks

# Test features
mvn test -Dgroups=Logintest
mvn test -Dgroups=LoginTest,CallsTest
mvn test -Dgroups=LoginTest,ContactsTest
mvn test -Dgroups=LoginTest,MeetingsTest
mvn test -Dgroups=LoginTest,TasksTest

# Test scenarios
mvn test -Dgroups=Logintest#testLogin
mvn test -Dgroups=LoginTest,CallsTest#testCalls
mvn test -Dgroups=LoginTest,ContactsTest#testContacts
mvn test -Dgroups=LoginTest,MeetingsTest#testMeetings
mvn test -Dgroups=LoginTest,TasksTest#testTasks