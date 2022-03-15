resource "aws_elastic_beanstalk_application" "application" {
  name        = "suitecrm-demo"
  description = "SuiteCRM Demo Project"
}

variable "instance" {}

resource "aws_elastic_beanstalk_environment" "environment" {
  name                = "suitecrm-demo"
  application         = aws_elastic_beanstalk_application.application.name
  solution_stack_name = "64bit Amazon Linux 2 v3.4.10 running Docker"
  
  // EC2 Instance Profile
  setting {
    namespace = "aws:autoscaling:launchconfiguration"
    name      = "IamInstanceProfile"
    value     = "aws-elasticbeanstalk-ec2-role"
  }

  // Server size
  setting {
    namespace = "aws:autoscaling:launchconfiguration"
    name = "InstanceType"
    value = var.instance
  }

  setting {
    namespace = "aws:autoscaling:launchconfiguration"
    name      = "RootVolumeSize"
    value     = "50"
  }
  
  // Environment Tags
  tags = {
    Name = "suitecrm-demo"
    Environment = "test"
  }
}

