Инструкция по развертыванию и установке приложения на удаленном хосте

Эта инструкция описывает шаги по развертыванию и установке сервиса для игры в "Бункер" Silo, представляющее из себя комбинацию SpringBoot и React.js приложений, с использованием Docker и Docker Compose для развертывания на удаленном сервере.

Шаг 1: Подготовка удаленного хоста
  Используйте SSH для подключения к удаленному серверу:
  ssh your_username@your_remote_host

Шаг 2: Установка программ для развертывания
  Перед началом развертывания сервиса, необходимо установить на удаленный сервер следующие программы:
    Docker;
    Docker Compose.
    
  Выполните следующие команды для установки Docker:
    sudo apt update
    sudo apt install apt-transport-https ca-certificates curl software-properties-common
    curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg
    echo "deb [arch=amd64 signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
    sudo apt update
    sudo apt install docker-ce

  Выполните следующие команды для установки Docker Compose:
    sudo curl -L "https://github.com/docker/compose/releases/download/v2.12.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
    sudo chmod +x /usr/local/bin/docker-compose

  Убедитесь, что Docker и Docker Compose установлены корректно:
    docker --version
    docker-compose --version

Шаг 3: Передача файлов на удаленный хост
  Используйте SCP (или rsync) для передачи файлов на удаленный сервер. В корне вашего проекта на локальной машине выполните:
    scp -r . your_username@your_remote_host:/path/to/remote/directory
  Также можете скопировать этот гит репозиторий на удаленный сервер, вместо передачи файлов вручную с утройства. 

Шаг 4: Запуск Docker Compose на удаленном хосте
    cd /path/to/remote/directory
  Выполните команду для сборки и запуска контейнеров:
    docker-compose up --build
    
Шаг 5: Проверка состояния контейнеров
    docker-compose ps
  Чтобы увидеть логи всех контейнеров, выполните:
    docker-compose logs

  Для просмотра логов конкретного контейнера:
    docker-compose logs app

Шаг 6: Доступ к приложению и pgAdmin
    Приложение будет доступно по адресу: http://your_remote_host:8080
    pgAdmin будет доступен по адресу: http://your_remote_host:5050
    
    Используйте следующие учетные данные для входа:
        Email: admin@admin.com
        Password: livmas

    После входа добавьте сервер с настройками:
        Hostname: db
        Port: 5432
        Maintenance database: postgres
        Username: postgres
        Password: livmas

Шаг 7: Очистка и остановка контейнеров
  Для остановки и удаления контейнеров и томов используйте:
    docker-compose down --volumes

Этот шаг остановит все контейнеры и удалит созданные тома.
