package com.example.smack

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_create_user.*
import java.util.*

class CreateUserActivity : AppCompatActivity() {

        var userAvatar = "profileDefault"
                            //R, G, B, alfa = transparencia
        var avatarColor = "[0.5, 0.5, 0.5, 1]"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
    }
    fun generateUserAvatar(view: View){
   //o random e o if é para nos dar o avatar se é claro ou escuro (entre 0 e 1)
        // e qual dos 27 é. caso calhe 0 na color é um avatar claro e caso calhe 22 no avatar
        // fica o nome que esta na pasta drawable -> light22 um sapo
    val random = Random()
        val color = random.nextInt(2)
        val avatar = random.nextInt(28)
        if(color == 0){
            userAvatar = "light$avatar"
        }else {
            userAvatar = "dark$avatar"
        }
        // agora vamos descobrir associar onde temos que ir buscar o recurso, ou seja o avatar que nos calhou
      //  resources.getIdentifier serve para descobrir on esta o que procuramos, por isso temos que lhe dar a descrição
        // dai o userAvatar, temos que dizer o tipo que é "drawable", e o nome onde esta guardado packageName
        val resourceId = resources.getIdentifier(userAvatar, "drawable", packageName)
        // isto esta a dizer ao createAvatarImageView(nome que demos ao botao) para ir buscar ao recursos uma imagem
        // com a localização resourceId
        createAvatarImageView.setImageResource(resourceId)
    }
    fun createUserClicked(view:View){

    }
    // vai nos dar o background do avatar, exemplo:
    // sapo escuro com background vermelho
    fun generateColorCLick (view: View){
        val random =Random()
        //RGB color's sao na maior parte até 256 dai fazermos random :
        val r = random.nextInt(255)
        val g = random.nextInt(255)
        val b = random.nextInt(255)
            // vai dar o background random ao avatar:
        createAvatarImageView.setBackgroundColor(Color.rgb(r,g,b))

        // para poder dar nos sitemas operativos, divide-se por 255 para ficar
        //com valores entre 0 e 1, e depois guarda se na var
        val savedR = r.toDouble() /255
        val savedG = g.toDouble()/255
        val savedB = b.toDouble()/255

        avatarColor = "$savedR, $savedG,$savedB,1"

    }


}
