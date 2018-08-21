package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class UserResponseMessage(userRequestIDField:UserRequestIDField,
                               usernameField:UsernameField,
                               userStatusField:Option[UserStatusField]=None,
                               userStatusTextField:Option[UserStatusTextField]=None) extends SfFixMessageBody("BF")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,userRequestIDField)
    fmt(b,usernameField)
    userStatusField.foreach(fmt(b,_))
    userStatusTextField.foreach(fmt(b,_))
    b
  }

}
     
object UserResponseMessage extends SfFixMessageDecoder {
  val MsgType="BF"
  val MsgName="UserResponse"
             
  override val MandatoryFields = HashSet[Int](
    UserRequestIDField.TagId, UsernameField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    UserStatusField.TagId, UserStatusTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==UserRequestIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(UserResponseMessage(UserRequestIDField.decode(myFields.get(UserRequestIDField.TagId)).get,
        UsernameField.decode(myFields.get(UsernameField.TagId)).get,
        myFields.get(UserStatusField.TagId).flatMap(f=>UserStatusField.decode(f)),
        myFields.get(UserStatusTextField.TagId).flatMap(f=>UserStatusTextField.decode(f))))
    } else None
  }

    
}
     