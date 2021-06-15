terraform {
  backend "s3" {
    bucket = "terraform-state-suitecrm"
    key    = "core/terraform.tfstate"
    region = "us-east-1"
  }
}
