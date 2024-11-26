# Importando bibliotecas necessárias para o Selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time

# Este código foi gerado para realizar um teste automatizado de login usando Selenium

url_base = "https://www.example.com.br/"

# Configuração do Selenium para o Chrome
driver = webdriver.Chrome()

# Iniciando a classe de teste
class TesteAutomatizado:
    def __init__(self, driver):
        self.driver = driver


    def acao_acessar_tela_login(self):
        driver = self.driver
        driver.get(url_base + "/login")
        self.assertIn("Python", driver.title)
        elem = driver.find_element(By.NAME, "q")
        elem.send_keys("pycon")
        elem.send_keys(Keys.RETURN)
        self.assertNotIn("No results found.", driver.page_source)

    def acao_preencher_campo_usuario(self):
        driver = self.driver
        elem = driver.find_element(By.ID, "input-usuario")
        elem.send_keys("algum valor")

    def acao_preencher_campo_senha(self):
        driver = self.driver
        elem = driver.find_element(By.ID, "input-senha")
        elem.send_keys("senha")

    def acao_clicar_botao_login(self):
        driver = self.driver
        elem = driver.find_element(By.ID, "btn-login")
        elem.click()

    def resultado_tela_principal_deve_estar_visivel(self):
        driver = self.driver
        elem = driver.find_element(By.ID, "tela-principal")
        self.assertTrue(elem.is_displayed())

    def resultado_mensagem_de_bem_vindo_deve_ser_exibida(self):
        driver = self.driver
        elem = driver.find_element(By.ID, "mensagem-bem-vindo")
        self.assertTrue(elem.is_displayed())
