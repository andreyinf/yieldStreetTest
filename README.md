# yieldStreet_test
This is my YieldStreet test using Maven, Eclipse IDE and page objects pattern.

To integrate this test in a CI/CD pipeline, we need to perform the follwoing steps:
- Configure a Docker Hub container
- Configure the yml file including the apps
- Define a service on Github to call the jenkins Github webhook
- Add a service by typing the url of the dockerized jenkins container
- Jenkins configuration in the docker compose file to run on port 8080
- Add Maven and Docker installer to the Jenkins Global Tool Configuration

Once a build be claimed, all the process will be triggered running the tests against a new application code.
Since a test be failed, the build cannot be deployed and a message must be configured to reach the team (by Teams, Slack, etc)



