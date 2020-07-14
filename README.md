# Dawid Ciechowski Personal Projects API

## Table of Contents

* [Introduction] (#introduction)
* [Technologies] (#technologies)
* [Usage] (#usage)

## Introduction

Projects API is a personally created API, hosted on Amazon Web Services, which can be used to obtain information about
my personal projects, which I've been working on over the years. 

## Technologies

- Java 11
- SpringBoot 2.3.1
- JavaX Persistence 2.2
- PostgreSQL 42.2.14
- AWS Elastic Beanstalk

## Usage

### GET Request for ALL projects

```
curl dawid-ciechowski.eu-west-2.elasticbeanstalk.com/api/v1/projects
```

### GET Request for a SINGLE project

```

curl dawid-ciechowski.eu-west-2.elasticbeanstalk.com/api/v1/projects/{project_id}
```

