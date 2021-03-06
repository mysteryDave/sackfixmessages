package org.sackfix.fix50sp1

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.xml
  */
case class ContraGrpComponent(noContraBrokersField:Option[NoContraBrokersField]=None,
                              contraBrokersGroups: Option[List[ContraBrokersGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noContraBrokersField.map(_.value).getOrElse(0) != contraBrokersGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoContraBrokersField.TagId,noContraBrokersField.map(_.value).getOrElse(0), contraBrokersGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noContraBrokersField.foreach(fmt(b,_))
    contraBrokersGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object ContraGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    ContraBrokersGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoContraBrokersField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    ContraBrokersGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    ContraBrokersGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoContraBrokersField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = ContraBrokersGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[ContraGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(ContraGrpComponent(myFields.get(NoContraBrokersField.TagId).flatMap(f=>NoContraBrokersField.decode(f)),
        if (nextTagPosLookup.contains(NoContraBrokersField.TagId)) ContraBrokersGroup.decode(flds, nextTagPosLookup(NoContraBrokersField.TagId)) else None))
    } else None
  }

    
}
     