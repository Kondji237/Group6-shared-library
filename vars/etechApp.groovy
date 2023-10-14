def call(String repoUrl){
    pipeline{
  agent any 
  stages{
    stage('clonecode'){
      steps{
        checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'team7-git-id', url: 'https://github.com/Kondji237/Project4Group6.git']])
        }
      }
            stage('1st parallel'){
      parallel{
      stage('Divine'){
        steps{
          sh 'uname -a'
          sh 'lscpu'
        }
      }
      stage('Ngantcha'){
        steps{
          sh 'df -h'
          sh 'free -g'
        }
      }
      }
      }
      stage('2nd parallel'){
      parallel{
      stage('Steeve'){
        steps{
          sh 'lsblk'
          sh 'uptime'
        }
      }
      stage('Ngaleu'){
        steps{
          sh 'cal'
          sh 'sudo systemctl status jenkins'
        }
      }
      }
            } 
  }
}
}