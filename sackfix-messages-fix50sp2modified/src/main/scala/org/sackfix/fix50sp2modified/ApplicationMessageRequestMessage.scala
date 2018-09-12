package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class ApplicationMessageRequestMessage(applReqIDField:ApplReqIDField,
                                            applReqTypeField:ApplReqTypeField,
                                            applIDRequestGrpComponent:Option[ApplIDRequestGrpComponent]=None,
                                            partiesComponent:Option[PartiesComponent]=None,
                                            textField:Option[TextField]=None,
                                            encodedTextLenField:Option[EncodedTextLenField]=None,
                                            encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("BW")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,applReqIDField)
    fmt(b,applReqTypeField)
    applIDRequestGrpComponent.foreach(fmt(b,_))
    partiesComponent.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object ApplicationMessageRequestMessage extends SfFixMessageDecoder {
  val MsgType="BW"
  val MsgName="ApplicationMessageRequest"
             
  override val MandatoryFields = HashSet[Int](
    ApplReqIDField.TagId, ApplReqTypeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    ApplIDRequestGrpComponent.isMandatoryField(tagId) || PartiesComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    ApplIDRequestGrpComponent.isOptionalField(tagId) || PartiesComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    ApplIDRequestGrpComponent.isFieldOf(tagId) || PartiesComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==ApplReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(ApplicationMessageRequestMessage(ApplReqIDField.decode(myFields.get(ApplReqIDField.TagId)).get,
        ApplReqTypeField.decode(myFields.get(ApplReqTypeField.TagId)).get,
        ApplIDRequestGrpComponent.decode(flds, startPos),
        PartiesComponent.decode(flds, startPos),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     