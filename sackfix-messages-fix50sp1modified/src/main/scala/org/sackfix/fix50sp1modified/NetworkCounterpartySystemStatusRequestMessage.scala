package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class NetworkCounterpartySystemStatusRequestMessage(networkRequestTypeField:NetworkRequestTypeField,
                                                         networkRequestIDField:NetworkRequestIDField,
                                                         compIDReqGrpComponent:Option[CompIDReqGrpComponent]=None) extends SfFixMessageBody("BC")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,networkRequestTypeField)
    fmt(b,networkRequestIDField)
    compIDReqGrpComponent.foreach(fmt(b,_))
    b
  }

}
     
object NetworkCounterpartySystemStatusRequestMessage extends SfFixMessageDecoder {
  val MsgType="BC"
  val MsgName="NetworkCounterpartySystemStatusRequest"
             
  override val MandatoryFields = HashSet[Int](
    NetworkRequestTypeField.TagId, NetworkRequestIDField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    CompIDReqGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int]()

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    CompIDReqGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    CompIDReqGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==NetworkRequestTypeField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(NetworkCounterpartySystemStatusRequestMessage(NetworkRequestTypeField.decode(myFields.get(NetworkRequestTypeField.TagId)).get,
        NetworkRequestIDField.decode(myFields.get(NetworkRequestIDField.TagId)).get,
        CompIDReqGrpComponent.decode(flds, startPos)))
    } else None
  }

    
}
     