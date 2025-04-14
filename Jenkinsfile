pipeline {
    agent any

    stages {
        stage('Obtener código fuente de GitHub') {
            steps {
                git credentialsId: 'github-token', url: 'https://github.com/Consu33/Jenkins.git', branch: 'main'
            }
        }

        stage('Análisis de código con SonarQube') {
            steps {
                echo 'Ejecutando análisis estático con SonarQube'
                withSonarQubeEnv('SonarQube') {
                    bat '"C:\\apache-maven\\apache-maven-3.9.9\\bin\\mvn.cmd" sonar:sonar'
                }
            }
        }

       stage('Compilar y ejecutar pruebas') {
            steps {
                echo 'Compilando código con Maven y ejecutando pruebas'
                bat '"C:\\apache-maven\\apache-maven-3.9.9\\bin\\mvn.cmd" clean install'
            }
        }

        stage('Desplegar aplicación') {
            steps {
                echo 'Desplegando aplicación en el servidor'
                bat 'scp target/*.jar Minsal@10.68.67.62:/ruta/deploy'
            }
        }
    }
}
